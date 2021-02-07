package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

  private List<Book> libraryBooks;

  public OrderedLibrary(List<Book> libraryBooks) {
    this.libraryBooks = libraryBooks;
  }

  public List<Book> orderedByTitle() {
    List<Book> orderedBooks =  new ArrayList<>(libraryBooks);
    Collections.sort(orderedBooks);
    return orderedBooks;
  }

  public List<Book> orderedByAuthor() {
    List<Book> orderedBooksByAuthor = libraryBooks;
    Collections.sort(orderedBooksByAuthor, new AuthorComparator());
    return orderedBooksByAuthor;
  }

  public List<String> orderedByTitleLocale(Locale locale) {
    List<String> orderedListByTitle = new ArrayList<>();
    for (Book book : libraryBooks) {
      orderedListByTitle.add(book.getTitle());
    }
    Collections.sort(orderedListByTitle, Collator.getInstance(new Locale("hu", "HU")));
    return orderedListByTitle;
  }

  public class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
      return o1.getAuthor().compareTo(o2.getAuthor());
    }
  }
}
