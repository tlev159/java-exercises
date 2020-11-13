package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

  public static void main(String[] args) {
    Client client = new Client();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a kliens nevét: ");
    client.name = scanner.nextLine();
    System.out.println("Kérem a kliens születési évét: ");
    client.year = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Kérem a kliens címét: ");
    client.address = scanner.nextLine();

    System.out.println(client.name);
    System.out.println(client.year);
    System.out.println(client.address);
  }
}
