package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoronaVaccinationMain {


  public static void main(String[] args) {

    CoronaVaccinationMain cvm = new CoronaVaccinationMain();

    MariaDbDataSource dataSource = new MariaDbDataSource();

    try {
      dataSource.setUrl("jdbc:mariadb://localhost:3306/corona?useUnicode=true");
      dataSource.setUser("coronavaccinadmin");
      dataSource.setPassword("coronavaccin");
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }

    CoronaDao coronaDao = new CoronaDao(dataSource);

    Scanner scanner = new Scanner(System.in);
    int pushedMenu = 0;

    while (pushedMenu != 6) {

      System.out.println("1. Regisztráció");
      System.out.println("2. Tömeges regisztráció");
      System.out.println("3. Generálás");
      System.out.println("4. Oltás");
      System.out.println("5. Oltás meghiúsulás");
      System.out.println("6. Kilépés");
      System.out.println("Kérem, adja meg a kívánt tevékenység sorszámát!");

      pushedMenu = scanner.nextInt();
      scanner.nextLine();

      switch (pushedMenu) {
        case 1:
          System.out.println("A regisztrációt választotta!");
          System.out.println(cvm.registrate(coronaDao));
          break;
        case 2:
          System.out.println("A tömeges regisztrációt választotta fájlbeolvasással!");
          System.out.println("Kérem adja meg a fájl helyét");
        cvm.registerFromCvdFile(coronaDao);
          break;

        case 3:
          System.out.println("A 'generálás' menüt választotta!");
        cvm.generating(coronaDao);
          break;

        case 4:
          System.out.println("Az 'oltás' menüt választotta!");
//        cvm.giveVaccin(coronaDao);
          break;

        case 5:
          System.out.println("Az 'oltás meghiúsulása' menüt' választotta!");
//        cvm.notGivenVaccin(coronaDao);
          break;

        case 6:
          System.out.println("Köszönöm közreműködését! Viszont látásra!");
//        byby();
          break;
      }

    }
  }

  private Citizens registrate(CoronaDao coronaDao) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem, adja meg az oltásra regisztáló adatait!");
    System.out.println("Teljes neve: ");
    String fullName = scanner.nextLine();
    if (fullName == null || fullName.isEmpty()) {
      throw new IllegalArgumentException("A név nem lehet null vagy üres!");
    }
    System.out.println("Lakhelyének irányítószáma:");
    int zip = Integer.parseInt(scanner.nextLine());
    String city = coronaDao.findTownWithTheGivenZip(zip);
    if (city.isEmpty()) {
      throw new IllegalArgumentException("Nincs ilyen irányítószámmal település!");
    }
    System.out.println("Város: " + coronaDao.findTownWithTheGivenZip(zip));
    System.out.println("Az oltásra regisztáló életkora:");
    int age = Integer.parseInt(scanner.nextLine());
    if (age < 10 || age > 150) {
      throw new IllegalArgumentException("Az életkor 10 és 150 között lehet!");
    }
    System.out.println("Az oltásra regisztáló e-mail címe:");
    String email1 = scanner.nextLine();
    if (email1 == null || email1.length() < 4 || !email1.contains("@")) {
      throw new IllegalArgumentException("Nem megfelelő e-mail cím!");
    }
    System.out.println("Kérem, adja meg ismét az e-mail címet:");
    String email2 = scanner.nextLine();
    if (!email1.equals(email2)) {
      throw new IllegalArgumentException("Nem egyező e-mail címek!");
    }
    System.out.println("Az oltásra regisztáló TAJ-száma:");
    String taj = scanner.nextLine();
    if (coronaDao.searchForExistingTaj(taj) != null) {
      throw new IllegalArgumentException("Már van ilyen TAJ-számú regisztáció!");
    }

    Citizens citizens = new Citizens(fullName, zip, age, email1, email2, taj);
    coronaDao.addCitizenToDatabase(citizens);
    return citizens;
  }

  public void registerFromCvdFile(CoronaDao coronaDao) {
    Scanner scanner = new Scanner(System.in);
    String file = scanner.nextLine();
    try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
      GroupRegistration gr = new GroupRegistration();
      List<Citizens> citizens = gr.readRegistrationDataFromFile(reader);
      coronaDao.insertGroupOfCitizens(citizens);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file", ioe);
    }
  }

  public void generating(CoronaDao coronaDao) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem adja meg a listázandó település irányítószámát!");
    int postalCode = Integer.parseInt(scanner.nextLine());
    System.out.println("Kérem adja meg, hogy milyen néven mentsem el a generált fájlt!");
    String fileName = scanner.nextLine();
    List<Citizens> citizensInGivenTown = coronaDao.findCitizensWithGivenPostalCode(postalCode);
    generateFile(fileName, citizensInGivenTown);
//    System.out.println(Arrays.asList(citizensInGivenTown));

  }

  private void generateFile(String fileName, List<Citizens> citizens) {
    List<Citizens> temp = new ArrayList<>();
    LocalDateTime firstTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(8,0));
    for (Citizens tempCitizen : citizens) {
      tempCitizen.setLastVaccination(firstTime);
      temp.add(tempCitizen);
      firstTime = firstTime.plusMinutes(30);
    }
//    System.out.println(Arrays.asList(temp));
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(fileName)))) {
      writer.println("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
      for (Citizens tmp : temp) {
        writer.print(tmp.getLastVaccination().getHour() + ":");
        writer.printf("%02d", tmp.getLastVaccination().getMinute());
        writer.print(";" + tmp.getFullName() + ";");
        writer.print(tmp.getZip() + ";");
        writer.print(tmp.getAge() + ";");
        writer.print(tmp.getEmail() + ";");
        writer.print(tmp.getTaj() + "\n");
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

}
