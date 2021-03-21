package coronaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CoronaService {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";

  private CoronaDao coronaDao;

  public CoronaService(CoronaDao coronaDao) {
    this.coronaDao = coronaDao;
  }

  public Citizen registrate() {
    CitizenValidation citizenValidation = new CitizenValidation();
    Scanner scanner = new Scanner(System.in);
    System.out.println(ANSI_BLUE + "Kérem, adja meg az oltásra regisztáló adatait!");
    System.out.println("Teljes neve: " + ANSI_RESET);
    String fullName = scanner.nextLine();
    while (!citizenValidation.isValidCitizenName(fullName)) {
      System.out.println("Helytelen név, kérem adja meg ismét!");
      fullName = scanner.nextLine();
    }
    System.out.println(ANSI_BLUE + "Lakhelyének irányítószáma:" + ANSI_RESET);
    int zip = Integer.parseInt(scanner.nextLine());
    String city = coronaDao.findTownWithTheGivenZip(zip);
    while (city == null || city.isEmpty() || !citizenValidation.isValidPostcode(zip)) {
      System.out.println(ANSI_BLACK + "Nincs ilyen irányítószámmal település!" + ANSI_RESET);
      System.out.println(ANSI_BLACK + "Kérem, adja meg ismét az irányítószámot!" + ANSI_RESET);
      zip = Integer.parseInt(scanner.nextLine());
      city = coronaDao.findTownWithTheGivenZip(zip);
    }
    System.out.println("Város: " + ANSI_GREEN + city + ANSI_RESET);
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló életkora:" + ANSI_RESET);
    int age = Integer.parseInt(scanner.nextLine());
    while (!citizenValidation.isValidAge(age)) {
      System.out.println("Érvénytelen életkort adott meg, kérem ismételje meg!");
      age = Integer.parseInt(scanner.nextLine());
    }
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló e-mail címe:" + ANSI_RESET);
    String email1 = scanner.nextLine();
    while (email1 == null || email1.length() < 4 || !email1.contains("@")) {
      System.out.println(ANSI_BLACK + "Nem megfelelő e-mail cím!" + ANSI_RESET);
      email1 = scanner.nextLine();
    }
    System.out.println(ANSI_BLUE + "Kérem, adja meg ellenőrzésképpen az e-mail címet mégegyszer:" + ANSI_RESET);
    String email2 = scanner.nextLine();
    while (!email1.equals(email2)) {
      System.out.println("Nem egyeznek meg az e-mail címek, kérem adja meg mégegyszer!");
      email2 = scanner.nextLine();
    }
    System.out.println(ANSI_BLUE + "Az oltásra regisztáló TAJ-száma:" + ANSI_RESET);
    String taj = scanner.nextLine();
    while (!citizenValidation.isTajValid(taj) || !citizenValidation.isTajExists(coronaDao, taj)) {
      if (!citizenValidation.isTajValid(taj)) {
        System.out.println(ANSI_RED + "A TAJ-szám érvénytelen! Kérjem, adjon meg érvényes TAJ-számot!" + ANSI_RESET);
        taj = scanner.nextLine();
      } else {
        System.out.println(ANSI_RED + "Ezzel a TAJ-számmal már regisztálták a(z) " + coronaDao.searchForExistingTaj(taj).getFullName() + " nevű pácienst!");
        System.out.println("Kérem adjon meg másik TAJ-számot!" + ANSI_RESET);
        taj = scanner.nextLine();
      }
    }

    Citizen citizen = new Citizen(fullName, zip, age, email1, taj);
    citizen = coronaDao.addCitizenToDatabase(citizen);

    return citizen;
  }


  public void registerFromCvdFile() {
    Scanner scanner = new Scanner(System.in);
    String file = scanner.nextLine();
    try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
      GroupRegistration gr = new GroupRegistration(coronaDao);
      List<Citizen> citizens = gr.readRegistrationDataFromFile(reader);
      coronaDao.insertGroupOfCitizens(citizens);
      System.out.println(ANSI_GREEN + citizens.size() + " fő regisztrálása megtörtént!" + ANSI_RESET);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file", ioe);
    }
  }


  public void generating() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(ANSI_BLUE + "Kérem adja meg a listázandó település irányítószámát!" + ANSI_RESET);
    int postalCode = Integer.parseInt(scanner.nextLine());
    String fileName = LocalDate.now().toString()+ "_" + postalCode + ".csv";
    List<Citizen> citizenInGivenTown = coronaDao.findCitizensWithGivenPostalCode(postalCode);
    citizenInGivenTown = selectToVaccinedCitizens(citizenInGivenTown);
    generateFile(fileName, citizenInGivenTown);
    System.out.println(ANSI_GREEN + "A fájl kiírása megtörtént (" + fileName + ") néven!" + ANSI_RESET);
  }

  private void generateFile(String fileName, List<Citizen> citizens) {
    LocalDateTime firstTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(8, 0));
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(fileName)))) {
      writer.println("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
      for (Citizen tmp : citizens) {
        writer.print(firstTime);
        writer.print(";" + tmp.getFullName() + ";");
        writer.print(tmp.getZip() + ";");
        writer.print(tmp.getAge() + ";");
        writer.print(tmp.getEmail() + ";");
        writer.print(tmp.getTaj() + "\n");
        firstTime = firstTime.plusMinutes(30);
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

  private List<Citizen> selectToVaccinedCitizens(List<Citizen> citizens) {
    List<Citizen> temp = new ArrayList<>();
    for (Citizen citizen : citizens) {
//      System.out.println(citizen.toString());
      if (citizen != null && citizen.getNumberOfVaccination() < 2 && (citizen.getLastVaccination() == null || citizen.getLastVaccination().plusDays(15).isBefore(LocalDate.now()))) {
        temp.add(citizen);
      }
    }
    return temp;
  }

  public void giveVaccin() {
    CitizenValidation citizenValidation = new CitizenValidation();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem adja meg a TAJ számot!");
    String taj = scanner.nextLine();
    citizenValidation.isTajValid(taj);
    Citizen citizen = coronaDao.searchCitizenAndVaccinationByTaj(taj);
    VaccinType givenVaccin = (citizen.getVaccinations().size() == 0 ? null : citizen.getVaccinations().get(0).getVaccinType());
    if (citizen != null && citizen.getNumberOfVaccination() == 2) {
      System.out.println("Ezzel a TAJ számmal a beteg már megkapta a második oltást is!");

    } else if (citizen != null && citizen.getNumberOfVaccination() == 1 && citizen.getLastVaccination().plusDays(15).isAfter(LocalDate.now())) {
      System.out.println(ANSI_RED + "Az előző oltás időpontja: " + citizen.getLastVaccination() + ", az oltás fajtája: " + givenVaccin.toString() + " volt.");
      System.out.println("Mivel az előző oltástól számítva még nem telt el 15 nap, így a második oltás még nem adható be!" + ANSI_RESET);
      return;
    } else if (citizen != null && citizen.getNumberOfVaccination() == 1 && citizen.getLastVaccination().plusDays(15).isBefore(LocalDate.now())) {
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

  public void deleteVaccinationWithNotes() {
    CitizenValidation citizenValidation = new CitizenValidation();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem adja meg a törlendő páciens TAJ-számát!");
    String taj = scanner.nextLine();
    while (!citizenValidation.isTajValid(taj)) {
      System.out.println("A megadott TAJ-szám helytelen! Kérem írja be mégegyszer!");
      taj = scanner.nextLine();
    }
    Citizen citizen = coronaDao.searchCitizenAndVaccinationByTaj(taj);
    System.out.println("Kérem adja meg a meghiúsulás okát!");
    String note = scanner.nextLine();
    coronaDao.deleteVaccinationWithNotes(taj, note);
  }

  public Map<Integer, List<Integer>> makeReport() {
    List<ReportForVaccination> temp = coronaDao.giveRegisteredCitizensBack();
      Map<Integer, List<Integer>> report = new TreeMap<>();
      for (ReportForVaccination rfv : temp) {
        if (!report.containsKey(rfv.getZip())) {
          report.put(rfv.getZip(), new ArrayList<>(3));
          report.get(rfv.getZip()).add(0);
          report.get(rfv.getZip()).add(0);
          report.get(rfv.getZip()).add(0);
        }
        report.get(rfv.getZip()).set(rfv.getNumberOfVaccination(), report.get(rfv.getZip()).get(rfv.getNumberOfVaccination()) + 1);
    }
      generateReportFile(report);
      return report;
  }

  private void generateReportFile(Map<Integer, List<Integer>> report) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
    String reportTime = LocalDateTime.now().format(formatter);
    String fileName = "Report_" + reportTime + ".csv";
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(fileName)))) {
      writer.println("Irányítószám;Még nem oltva;Egyszer oltva;Második oltást is megkapta");
      for (Map.Entry<Integer, List<Integer>> temp : report.entrySet()) {
        writer.print(temp.getKey() + ";");
        writer.print(temp.getValue().get(0) + ";");
        writer.print(temp.getValue().get(1) + ";");
        writer.print(temp.getValue().get(2) + "\n");
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }


  private VaccinType witchVaccin(int vaccin) {
    return VaccinType.values()[vaccin - 1];
  }


}
