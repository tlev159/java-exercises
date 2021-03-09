package filescanner.library;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

  private static final String DELIMITER = ";|(\r\n)";

  private List<Book> books = new ArrayList<>();

  public void add(Book... books) {
    for (Book b : books) {
      this.books.add(b);
    }
  }

  public void loadFromFile() {
    try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/booksFileScanner.csv"))){

      while (scanner.hasNext()) {
        String[] line = scanner.nextLine().split(DELIMITER);
        String regNumber = line[0];
        String author = line[1];
        String title = line[2];
        add(new Book(regNumber, author, title));
      }
    }
  }

  public List<Book> getBooks() {
    return new ArrayList<>(books);
  }
}
