package sorting;

import java.util.Objects;

public class Book implements Comparable<Book> {

  private int id;
  private String author;
  private String title;

  public Book(int id, String author, String title) {
    this.id = id;
    this.author = author;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return id + " " + title + " " + author;
  }

  @Override
  public int compareTo(Book o) {
    return Integer.valueOf(this.id).compareTo(Integer.valueOf(o.id));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return id == book.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
