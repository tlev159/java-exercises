package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.util.Scanner;

public class CoronaVaccinationMain {

  MariaDbDataSource dataSource;

  public static void main(String[] args) {

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
//        registrating();
          break;
        case 2:
          System.out.println("A tömeges regisztrációt választotta fájlbeolvasással!");
          System.out.println("Kérem adja meg a fájl helyét");
//        massRegistrating();
          break;

        case 3:
          System.out.println("A 'generálás' menüt választotta!");
//        generating();
          break;

        case 4:
          System.out.println("Az 'oltás' menüt választotta!");
//        giveVaccin();
          break;

        case 5:
          System.out.println("Az 'oltás meghiúsulása' menüt' választotta!");
//        notGivenVaccin();
          break;

        case 6:
          System.out.println("Köszönöm közreműködését! Viszont látásra!");
//        byby();
          break;
      }

    }
  }
}
