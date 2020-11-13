package classstructureintegrate;

import java.util.Scanner;

public class Bank {

  public static void main(String[] args) {
    BankAccount account1 = new BankAccount("123456-123456", "Valaki1", 123456);
    BankAccount account2 = new BankAccount("12345-12345", "Valaki2", 160000);

    System.out.println(account1.getInfo());
    System.out.println(account2.getInfo());

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem, hogy mekkora összeget szeretne betenni!");
    account1.deposit(scanner.nextInt());
    System.out.println(account1.getInfo());

    System.out.println("Kérem, hogy mekkora összeget szeretne kivenni!");
    account2.withdraw(scanner.nextInt());
    scanner.nextLine();
    System.out.println(account2.getInfo());

    System.out.println("Kérem, hogy melyik számlára szeretne betenni és mekkora összeget!");
    String toAccount = scanner.nextLine();
    int toBalance = scanner.nextInt();
    account1.transfer(account2, toBalance);

    System.out.println(account1.getInfo());
    System.out.println(account2.getInfo());

  }
}
