package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class CoronaVaccinationMain {


  public static void main(String[] args) {

    CoronaVaccinationMain cvm = new CoronaVaccinationMain();

    MariaDbDataSource dataSource;

    try {
      dataSource = new MariaDbDataSource();
      dataSource.setUrl("jdbc:mariadb://localhost:3306/corona:useUniset=true");
      dataSource.setUser("coronavaccinadmin");
      dataSource.setPassword("coronavaccin");
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }

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
          System.out.println(cvm.registrate(dataSource));
          break;
        case 2:
          System.out.println("A tömeges regisztrációt választotta fájlbeolvasással!");
          System.out.println("Kérem adja meg a fájl helyét");
//        cvm.massRegistrating(datasource);
          break;

        case 3:
          System.out.println("A 'generálás' menüt választotta!");
//        cvm.generating(datasource);
          break;

        case 4:
          System.out.println("Az 'oltás' menüt választotta!");
//        cvm.giveVaccin(datasource);
          break;

        case 5:
          System.out.println("Az 'oltás meghiúsulása' menüt' választotta!");
//        cvm.notGivenVaccin(datasource);
          break;

        case 6:
          System.out.println("Köszönöm közreműködését! Viszont látásra!");
//        byby();
          break;
      }

    }
  }

  private Citizens registrate(MariaDbDataSource dataSource) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem, adja meg az oltásra regisztáló adatait!");
    System.out.println("Teljes neve: ");
    String fullName = scanner.nextLine();
    System.out.println("Lakhelyének irányítószáma:");
    int zip = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Az oltásra regisztáló életkora:");
    int age = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Az oltásra regisztáló e-mail címe:");
    String email1 = scanner.nextLine();;
    System.out.println("Kérem, adja meg ismét az e-mail címet:");
    String email2 = scanner.nextLine();;
    System.out.println("Az oltásra regisztáló TAJ-száma:");
    String taj = scanner.nextLine();;

    Citizens citizens = new Citizens(fullName, zip, age, email1, email2, taj);

    return citizens;
  }
}
