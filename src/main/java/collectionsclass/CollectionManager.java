package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

  private List<Book> library;

  public CollectionManager(List<Book> library) {
    this.library = library;
  }

  public List<Book> createUnmodifiableLibrary() {
    List<Book> l = Collections.unmodifiableList(library);
    return l;
  }

  public List<Book> reverseLibrary() {
    List<Book> reverseL = new ArrayList<>(library);
    Collections.reverse(reverseL);
    return reverseL;
  }

  public Book getFirstBook() {
    return library.get(0);
  }

  public Book getLastBook() {
    return library.get(library.size() - 1);
  }

}
