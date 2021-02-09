package searching;

import java.util.Arrays;

public class BookArraySearch {

  private Book[] bookArray;

  public BookArraySearch(Book[] bookArray) {
    this.bookArray = bookArray;
  }

  public Book findBookByAuthorTitle(String author, String title) {
    if (author == null || title == null || author.equals("") || title.equals("")) {
      throw new IllegalArgumentException("Author or title must not be empty!");
    }
    Book searchedBook = new Book(author, title);
    Arrays.sort(bookArray);
    int indexAuthor = Arrays.binarySearch(bookArray, searchedBook);
    if (indexAuthor >= 0) {
      return bookArray[indexAuthor];
    }
    throw new IllegalArgumentException("No book found by " + author + " with title " + title);
  }
}
