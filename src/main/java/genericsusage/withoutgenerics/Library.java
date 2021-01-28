package genericsusage.withoutgenerics;


import genericsusage.Book;

import java.util.List;

public class Library {

  public Book getFirstBook(List books) {
    if (books == null) {
      throw new NullPointerException("Argument should be not null!");
    }
    if (books.isEmpty()) {
      throw new IllegalArgumentException("Argument should not be empty!");
    }
    Object o = books.get(0);
    if ((o instanceof Book) == false) {
      throw new ClassCastException("Not a book");
    }
    return (Book) o;
  }
}
