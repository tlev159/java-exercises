package arraylist;

import classstructureconstructors.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Books {

  List<String> bookTitles = new ArrayList<>();

  public void add(String title) {
    bookTitles.add(title);
  }

  public List<String> findAllByPrefix(String prefix) {
    List<String> titleContainsPrefix = new ArrayList<>();
    for (String title : bookTitles) {
      if (title.indexOf(prefix) == 0) {
        titleContainsPrefix.add(title);
      }
    }
    return titleContainsPrefix;
  }

  public List<String> getTitles() {
    return bookTitles;
  }

  public static void main(String[] args) {
    Books books = new Books();

    books.add("Add ide azt...");
    books.add("Add ide azt a kockát");
    books.add("Ide add azt a kockát");
    books.add("Ide ne add azt a téglalapot");

    System.out.println(books.findAllByPrefix("Add").toString());
    System.out.println(books.getTitles().toString());
  }
}
