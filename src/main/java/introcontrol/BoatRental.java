package introcontrol;

import java.util.Scanner;

public class BoatRental {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a csoport létszámát!");
    int numberOfPeople = scanner.nextInt();

    if (numberOfPeople > 10) {
      System.out.println(numberOfPeople - 10 + " fő maradt a parton.");
    } else if (numberOfPeople > 8) {
      System.out.println("Mindhárom csónak kiment.");
    } else if (numberOfPeople == 8) {
      System.out.println("Az 5-ös és 3-as csónak ment ki, a 2-es csónak maradt a parton.");
    } else if (numberOfPeople > 5) {
      System.out.println("Az 5-ös és 2-es csónak ment ki, a 3-as csónak maradt a parton.");
    } else if (numberOfPeople > 3) {
      System.out.println("Az 5-ös csónak ment ki, a 3-as és 2-es csónak maradt a parton.");
    } else if (numberOfPeople == 3) {
    System.out.println("Az 3-as csónak ment ki, az 5-ös és 2-es csónak maradt a parton.");
    } else if (numberOfPeople > 0) {
    System.out.println("A 2-es csónak ment ki, az 5-ös és 3-as csónak maradt a parton.");
    }
  }
}
