package statements;

import java.util.Scanner;

public class DivByThree {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a vizsgálandó számot!");
    int number = scanner.nextInt();
    if (number % 3 == 0) {
      System.out.println("A szám osztható hárommal!");
    } else {
      System.out.println("A szám nem osztható hárommal!");
    }
  }
}
