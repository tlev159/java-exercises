package introcontrol;

import java.util.Scanner;

public class Sum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int sum = 0;
    System.out.println("Kérek 5 számot!");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + 1 + ".: ");
      sum += scanner.nextInt();
    }
    System.out.println("Az összegük: " + sum);
  }
}
