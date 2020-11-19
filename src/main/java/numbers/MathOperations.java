package numbers;

import java.util.Scanner;

public class MathOperations {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Mennyi az eredménye a következő kifejezésnek?");
    System.out.println("((2 + 2) * 3 - 8 / 4) / 4 ");
    double givenResoult = ((2.0 + 2) * 3 - 8 / 4) / 4;
    double resoult = scanner.nextDouble();

    if (Math.abs(givenResoult - resoult) < 0.00005) {
      System.out.println("Az eredmény helyes!");
    } else {
      System.out.println("A számolásoddal gond van! Az eredmény: " + givenResoult);
    }

  }
}
