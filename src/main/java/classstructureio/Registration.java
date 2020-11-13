package classstructureio;

import java.util.Scanner;

public class Registration {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Kérem a regisztációs nevet: ");
    String name = scanner.nextLine();
    System.out.println("Kérem az e-mail címet:");
    String email = scanner.nextLine();

    System.out.println("A regisztrációs adatok:");
    System.out.println("Név: " + name);
    System.out.println("e-mail: " + email);
  }
}
