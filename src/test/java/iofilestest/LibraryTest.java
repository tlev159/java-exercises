package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

  @TempDir
  public Path folder;

  @Test
  void add() {
    Library library = new Library();

    assertEquals(0, library.getBooks().size());

    library.add(new Book("John Doe", "Java is the best"));
    library.add(new Book("Jane Doe", "McDonald"));

    assertEquals(2, library.getBooks().size());
    assertEquals("John Doe", library.getBooks().get(0).getAuthor());
    assertEquals("McDonald", library.getBooks().get(1).getTitle());

  }

  @Test
  void saveBooksTest() {

    Library library = new Library();
    library.add(new Book("John Doe", "Java is the best"));
    library.add(new Book("Jane Doe", "McDonald"));
    library.add(new Book("Jack Doe", "Dough Makaida"));

    library.saveBooks(folder.resolve("bookLibrary.txt"));

    List<Book> exampleBooks = library.loadBooks(folder.resolve("bookLibrary.txt"));

    assertEquals("Jack Doe", exampleBooks.get(2).getAuthor());
    assertEquals(3, exampleBooks.size());

  }

}