package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

  private Book[] bookArray;

  public OrderedArrayLibrary(Book[] bookArray) {
    this.bookArray = bookArray;
  }

  public Book[] sortingById() {
    Book[] result = new Book[bookArray.length];
    System.arraycopy(bookArray, 0, result, 0, bookArray.length);
    Arrays.sort(result);
    return result;
  }

  public Book[] sortingByTitle() {
    Book[] result = new Book[bookArray.length];
    System.arraycopy(bookArray, 0, result, 0, bookArray.length);
    Arrays.sort(result, new Comparator<Book>() {
      @Override
      public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
      }
    });
    System.out.println(bookArray[0]);
    System.out.println(result[0]);
    return result;
  }

}
