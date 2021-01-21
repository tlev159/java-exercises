package week02d03;

import java.util.Scanner;

public class InputNames {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] names = new String[5];

    System.out.println("Kérek 5 nevet: ");

    for (int i = 0; i < 5; i++) {
      names[i] = scanner.nextLine();
    }

    for (int i = 0; i < 5; i++) {
      System.out.println((i+1) + ". elem: " + names[i]);
    }

  }
}