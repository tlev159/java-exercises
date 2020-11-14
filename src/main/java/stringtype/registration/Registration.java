package stringtype.registration;

import java.util.Scanner;

public class Registration {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a felhasználónevet:");
    String name = scanner.nextLine();

    System.out.println("Kérem a jelszót!");
    String password1 = scanner.nextLine();

    System.out.println("Kérem a jelszót még egyszer!");
    String password2 = scanner.nextLine();

    System.out.println("Kérem az e-mail címet!");
    String email = scanner.nextLine();

    Uservalidator uservalidator = new Uservalidator(name,password1, email);

    System.out.println("A felhasználónév helyes: " + uservalidator.isValidUsername(name));
    System.out.println("A jelszó érvényes: " + uservalidator.isValidPassword(password1, password2));
    System.out.println("A felhasználónév helyes: " + uservalidator.isValidEmail(email));
  }
}
