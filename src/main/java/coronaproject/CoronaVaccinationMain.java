package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
    MariaDbDataSource dataSource = new MariaDbDataSource();

    try {
      dataSource.setUrl("jdbc:mariadb://localhost:3306/corona?useUnicode=true");
      dataSource.setUser("coronavaccinadmin");
      dataSource.setPassword("coronavaccin");
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }

    CoronaDao coronaDao = new CoronaDao(dataSource);
    CoronaSystem coronaSystem = new CoronaSystem(coronaDao);

    Scanner scanner = new Scanner(System.in);
    int pushedMenu = 0;

    while (pushedMenu != 6) {

      System.out.println("1. Személyek regisztrációja oltásra");
      System.out.println("2. Tömeges regisztráció fájlból");
      System.out.println("3. Oltási időpontok generálása a holnapi napra irányítószám alapján");
      System.out.println("4. Oltás vagy annak meghíúsulásának rögzítése");
      System.out.println("5. Riport készítése az oltásokról");
      System.out.println("6. Kilépés");
      System.out.println("Kérem, adja meg a kívánt menüpont sorszámát!");

      pushedMenu = Integer.parseInt(scanner.nextLine());

      switch (pushedMenu) {
        case 1:
          System.out.println(ANSI_PURPLE + "A regisztrációt választotta!" + ANSI_RESET);
          coronaSystem.registrate();
          System.out.println(ANSI_GREEN + "Sikeres regisztáció!" + ANSI_RESET + "\n");
          break;
        case 2:
          System.out.println(ANSI_PURPLE + "A tömeges regisztrációt választotta fájlbeolvasással!");
          System.out.println("Kérem adja meg a fájl helyét" + ANSI_RESET);
          coronaSystem.registerFromCvdFile();
          break;

        case 3:
          System.out.println(ANSI_PURPLE + "A 'generálás' menüt választotta!" + ANSI_RESET);
          coronaSystem.generating();
          break;

        case 4:
          System.out.println(ANSI_PURPLE + "Az 'oltás vagy annak meghíúsulásának rögzítése' menüt választotta!" + ANSI_RESET);
          System.out.println(ANSI_PURPLE + "Kérem adja meg, hogy (1) oltást szeretne rögzíteni vagy (2) törölni szeretne!" + ANSI_RESET);
          int registerOrDelete = Integer.parseInt(scanner.nextLine());
          if (registerOrDelete == 1) {
              coronaSystem.giveVaccin();
              System.out.println("Az oltás regisztrálása megtörtént!");
            } else if (registerOrDelete == 2) {
              coronaSystem.deleteVaccinationWithNotes();
              System.out.println("A törlés regisztációja megtörtént!");
            }
          break;

        case 5:
          System.out.println(ANSI_PURPLE + "Készítem a riportot az aktuáális adatok alapján!" + ANSI_RESET);
          Map<Integer, List<Integer>> report = new TreeMap<>();
          report = coronaSystem.makeReport();
          System.out.println(ANSI_BLUE + report + ANSI_RESET);
          break;

        case 6:
          System.out.println(ANSI_RED + "Köszönöm közreműködését! Viszont látásra!" + ANSI_RESET);
          break;

        default:
          System.out.println("Ilyen menüpont nincs! Kérem, a lehetséges menüpontokból válasszon!");
      }
    }
  }



}
