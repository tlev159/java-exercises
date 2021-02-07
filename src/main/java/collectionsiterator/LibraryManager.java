package collectionsiterator;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LibraryManager {

  private Set<Book> libraryBooks;

  public LibraryManager(Set<Book> libraryBooks) {
    this.libraryBooks = libraryBooks;
  }

  public Book findBookByRegNumber(int regNumber) {
    Iterator<Book> i = libraryBooks.iterator();
    while (i.hasNext()) {
      Book searched = i.next();
      if (searched.getRegNumber() == regNumber) {
        return searched;
      }
    }
    throw new MissingBookException("No books found with regnumber: " + regNumber);
  }

  public int removeBookByRegNumber(int regNumber) {
    Iterator<Book> i = libraryBooks.iterator();
    while (i.hasNext()) {
      if (i.next().getRegNumber() == regNumber) {
        i.remove();
        return regNumber;
      }
    }
    throw new MissingBookException("No books found with regnumber: " + regNumber);
  }

  public Set<Book> selectBooksByAuthor(String author) {
    Set<Book> books = new TreeSet<>();
    Iterator<Book> i = libraryBooks.iterator();
    while (i.hasNext()) {
      Book searches = i.next();
      if (searches.getAuthor().equals(author)) {
        books.add(searches);
      }
    }
    if (books.size() < 1) {
      throw new MissingBookException("No books found by " + author);
    }
    return books;
  }

  public int libraryBooksCount() {
    return libraryBooks.size();
  }
}
