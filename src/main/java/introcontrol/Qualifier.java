package introcontrol;

import java.util.Scanner;

public class Qualifier {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérek egy számot!");
    if (scanner.nextInt() > 100) {
      System.out.println("nagyobb, mint 100");
    } else {
      System.out.println(" a szám 100 vagy annál kisebb");
    }
  }
}
