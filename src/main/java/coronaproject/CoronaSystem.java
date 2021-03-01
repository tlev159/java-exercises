package coronaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class CoronaSystem {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";


  public Citizens registrate(CoronaDao coronaDao) {
    CitizenValidation citizenValidation = new CitizenValidation();
    Scanner scanner = new Scanner(System.in);
    System.out.println(ANSI_BLUE + "Kérem, adja meg az oltásra regisztáló adatait!");
    System.out.println("Teljes neve: " + ANSI_RESET);
    String fullName = scanner.nextLine();
    citizenValidation.isValidCitizenName(fullName);
    System.out.println(ANSI_BLUE + "Lakhelyének irányítószáma:" + ANSI_RESET);
    int zip = Integer.parseInt(scanner.nextLine());
    String city = coronaDao.findTownWithTheGivenZip(zip);
    citizenValidation.isValidPostcode(zip);
    if (city.isEmpty()) {
      throw new IllegalArgumentException(ANSI_BLACK + "Nincs ilyen irányítószámmal település!" + ANSI_RESET);
    }
    System.out.println("Város: " + ANSI_GREEN + coronaDao.findTownWithTheGivenZip(zip) + ANSI_RESET);
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló életkora:" + ANSI_RESET);
    int age = Integer.parseInt(scanner.nextLine());
    citizenValidation.isValidAge(age);
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló e-mail címe:" + ANSI_RESET);
    String email1 = scanner.nextLine();
    if (email1 == null || email1.length() < 4 || !email1.contains("@")) {
      throw new IllegalArgumentException(ANSI_BLACK + "Nem megfelelő e-mail cím!" + ANSI_RESET);
    }
    System.out.println(ANSI_BLUE + "Kérem, adja meg ismét az e-mail címet:" + ANSI_RESET);
    String email2 = scanner.nextLine();
    if (!email1.equals(email2)) {
      throw new IllegalArgumentException("Nem egyező e-mail címek!");
    }
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló TAJ-száma:" + ANSI_RESET);
    String taj = scanner.nextLine();
    citizenValidation.isTajExists(coronaDao, taj);
    citizenValidation.isTajValid(taj);

    Citizens citizens = new Citizens(fullName, zip, age, email1, email2, taj);
    coronaDao.addCitizenToDatabase(citizens);
    return citizens;
  }


  public void registerFromCvdFile(CoronaDao coronaDao) {
    Scanner scanner = new Scanner(System.in);
    String file = scanner.nextLine();
    try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
      GroupRegistration gr = new GroupRegistration();
      List<Citizens> citizens = gr.readRegistrationDataFromFile(reader, coronaDao);
      coronaDao.insertGroupOfCitizens(citizens);
      System.out.println(ANSI_GREEN + citizens.size() + " fő regisztrálása megtörtént!" + ANSI_RESET);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file", ioe);
    }
  }


  public void generating(CoronaDao coronaDao) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(ANSI_BLUE + "Kérem adja meg a listázandó település irányítószámát!" + ANSI_RESET);
    int postalCode = Integer.parseInt(scanner.nextLine());
    System.out.println(ANSI_BLUE + "Kérem adja meg, hogy milyen néven mentsem el a generált fájlt!" + ANSI_RESET);
    String fileName = scanner.nextLine();
    List<Citizens> citizensInGivenTown = coronaDao.findCitizensWithGivenPostalCode(postalCode);
    citizensInGivenTown = selectToVaccinedCitizens(citizensInGivenTown);
    generateFile(fileName, citizensInGivenTown);
//    System.out.println(Arrays.asList(citizensInGivenTown));
    System.out.println(ANSI_GREEN + "A fájl kiírása megtörtént!" + ANSI_RESET);
  }

  private void generateFile(String fileName, List<Citizens> citizens) {
    List<Citizens> temp = new ArrayList<>();
    LocalDateTime firstTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(8, 0));
    for (Citizens tempCitizen : citizens) {
      tempCitizen.setLastVaccination(firstTime);
      temp.add(tempCitizen);
      firstTime = firstTime.plusMinutes(30);
    }
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(fileName)))) {
      writer.println("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
      for (Citizens tmp : temp) {
        writer.print(tmp.getLastVaccination());
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

  private List<Citizens> selectToVaccinedCitizens(List<Citizens> citizens) {
    List<Citizens> temp = new ArrayList<>();
    for (Citizens citizen : citizens) {
      System.out.println(citizen.toString());
      if (citizen != null && citizen.getNumberOfVaccination() < 2 && citizen.getLastVaccination().plusDays(15).isBefore(LocalDateTime.now())) {
        temp.add(citizen);
      }
    }
    return temp;
  }

  public void giveVaccin(CoronaDao coronaDao) {
    CitizenValidation citizenValidation = new CitizenValidation();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem adja meg a TAJ számot!");
    String taj = scanner.nextLine();
    citizenValidation.isTajValid(taj);
    Citizens citizen = coronaDao.searchCitizenAndVaccinationByTaj(taj);
    VaccinType givenVaccin = (citizen.getVaccinations().size() == 0 ? null : citizen.getVaccinations().get(0).getVaccinType());
    if (citizen != null && citizen.getNumberOfVaccination() == 2) {
      System.out.println("Ezzel a TAJ számmal a beteg már megkapta a második oltást is!");

    } else if (citizen != null && citizen.getNumberOfVaccination() == 1 && citizen.getLastVaccination().plusDays(15).isAfter(LocalDateTime.now())) {
      System.out.println(ANSI_RED + "Az előző oltás időpontja: " + citizen.getLastVaccination() + ", az oltás fajtája: " + givenVaccin.toString() + " volt.");
      System.out.println("Mivel az előző oltástól számítva még nem telt el 15 nap, így a második oltás még nem adható be!" + ANSI_RESET);
      return;
    } else if (citizen != null && citizen.getNumberOfVaccination() == 1 && citizen.getLastVaccination().plusDays(15).isBefore(LocalDateTime.now())) {
      System.out.println("Az első oltás időpontja: " + ANSI_GREEN + citizen.getLastVaccination() + ANSI_RESET + ", az oltás fajtája: " + ANSI_GREEN + givenVaccin.toString() + ANSI_RESET + " volt.");
    }
    System.out.println("Kérem adja meg az oltás dátumát (éééé-hh-nn formátumban)!");
    LocalDate vaccinDate = LocalDate.parse(scanner.nextLine());
    System.out.println(vaccinDate);
    System.out.println("(1. Pfizer; 2. AstraZeneca; 3. Moderna; 4. Sputnik V; 5. Sinopharm)");
    System.out.println("Kérem adja meg a vakcina sorszámát!");
    VaccinType vaccin = witchVaccin(Integer.parseInt(scanner.nextLine()));
    System.out.println("A(z) " + vaccin.toString() + " vakcinát választotta!");
    if (citizen.getNumberOfVaccination() == 0 || citizen.getNumberOfVaccination() == 1 && vaccin == givenVaccin) {
      coronaDao.vaccination(vaccinDate, taj, vaccin);
    } else {
      throw new IllegalArgumentException("A két vakcinának meg kell egyeznie!");
    }
  }

  public void makeReport(CoronaDao coronaDao) {
    List<ReportForVaccination> temp = coronaDao.giveRegisteredCitizensBack();
      Map<Integer, Integer> report = new TreeMap<>();
      for (ReportForVaccination rfv : temp) {
        if (!report.containsKey(rfv.getZip())) {
          report.put(rfv.getZip(), rfv.getNumberOfVaccination());
        } else {
          report.put(rfv.getZip(), report.get(rfv.getZip()) + rfv.getNumberOfVaccination());
        }
    }
    System.out.println(ANSI_BLUE + report + ANSI_RESET);
  }

  private VaccinType witchVaccin(int vaccin) {
    return VaccinType.values()[vaccin - 1];
  }


}
