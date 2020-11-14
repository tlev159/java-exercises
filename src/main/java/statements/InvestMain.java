package statements;

import java.util.Scanner;

public class InvestMain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a befektetés összegét:");
    int fund = scanner.nextInt();
    System.out.println("Kamatláb:");
    int rate = scanner.nextInt();

    Investment investment = new Investment(fund,rate);

    System.out.println("Kérem, hogy hány napra számoljak hozamot!");
    int days1 = scanner.nextInt();
    System.out.println("Hozam " + days1 + " napra: " + investment.getYield(days1));

    System.out.println("Kérem a zárás napját napokban");
    int days2 = scanner.nextInt();
    System.out.println("A hozam " + days2 + " nap után: " + investment.close(days2));
    System.out.println("Kérem a zárás napját napokban");
    int days3 = scanner.nextInt();
    System.out.println("A hozam " + days3 + " nap után: " + investment.close(days3));


  }
}
