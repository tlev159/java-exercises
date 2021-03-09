package filescanner.library;

public class Book {

  private String regNumber;
  private String author;
  private String title;

  public Book(String regNumber, String author, String title) {
    this.regNumber = regNumber;
    this.author = author;
    this.title = title;
  }

  public String getRegNumber() {
    return regNumber;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }
}
