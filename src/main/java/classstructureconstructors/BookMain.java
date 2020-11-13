package classstructureconstructors;

import java.util.Scanner;

public class BookMain {

  public static void main(String[] args) {
    Book book = new Book("Nagy Író", "Én is írtam valamit!");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a " + book.getAuthor() + ":" + book.getTitle() + " könyv regisztációs számát!");
    book.register(scanner.nextLine());

    System.out.println("A könyv a " + book.getRegNumber() + " számon regisztrálásra került.");
  }
}
