package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class CoronaVaccinationMain {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";

  private CitizenValidation citizenValidation;

  public void setCitizenValidation(CitizenValidation citizenValidation) {
    this.citizenValidation = citizenValidation;
  }

  public static void main(String[] args) {

    CoronaVaccinationMain cvm = new CoronaVaccinationMain();
    cvm.setCitizenValidation(new CitizenValidation());
    CoronaSystem coronaSystem = new CoronaSystem();
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

    while (pushedMenu != 7) {

      System.out.println("1. Személyek regisztrációja oltásra");
      System.out.println("2. Tömeges regisztráció fájlból");
      System.out.println("3. Oltási időpontok generálása a holnapi napra irányítószám alapján");
      System.out.println("4. Oltás rögzítése");
      System.out.println("5. Oltás meghiúsulás rögzítése");
      System.out.println("6. Riport készítése az oltásokról");
      System.out.println("7. Kilépés");
      System.out.println("Kérem, adja meg a kívánt menüpont sorszámát!");

      pushedMenu = Integer.parseInt(scanner.nextLine());

      switch (pushedMenu) {
        case 1:
          System.out.println(ANSI_PURPLE + "A regisztrációt választotta!" + ANSI_RESET);
          coronaSystem.registrate(coronaDao);
          System.out.println(ANSI_GREEN + "Sikeresen regisztáció!" + ANSI_RESET + "\n");
          break;
        case 2:
          System.out.println(ANSI_PURPLE + "A tömeges regisztrációt választotta fájlbeolvasással!");
          System.out.println("Kérem adja meg a fájl helyét" + ANSI_RESET);
        coronaSystem.registerFromCvdFile(coronaDao);
          break;

        case 3:
          System.out.println(ANSI_PURPLE + "A 'generálás' menüt választotta!" + ANSI_RESET);
        coronaSystem.generating(coronaDao);
          break;

        case 4:
          System.out.println(ANSI_PURPLE + "Az 'oltás' menüt választotta!" + ANSI_RESET);
        coronaSystem.giveVaccin(coronaDao);
          break;

        case 5:
          System.out.println(ANSI_PURPLE + "Az 'oltás meghiúsulása' menüt' választotta!" + ANSI_RESET);
//        cvm.notGivenVaccin(coronaDao);
          break;

        case 6:
          System.out.println(ANSI_PURPLE + "Készítem a riportot az aktuáális adatok alapján!" + ANSI_RESET);
//        coronaSystem.makeRiport();
          break;

        case 7:
          System.out.println(ANSI_RED + "Köszönöm közreműködését! Viszont látásra!" + ANSI_RESET);
//        byby();
          break;

        default:
          System.out.println("Ilyen menüpont nincs! Kérem, a lehetséges menüpontokból válasszon!");
      }
    }
  }



}
