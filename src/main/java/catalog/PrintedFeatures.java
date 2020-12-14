package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{

  private List<String> authors;
  private int numberOfPages;
  private String title;

  Validators valid = new Validators();

  public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
    if (valid.isBlank(title)) {
      throw new IllegalArgumentException("Empty title");
    }
    this.title = title;
    if (numberOfPages < 1) {
      throw new IllegalArgumentException("Number of pages is not valid!");
    }
    this.numberOfPages = numberOfPages;
    if (valid.isEmpty(authors)) {
      throw new IllegalArgumentException("Autor must not be empty or nul!");
    }
    this.authors = authors;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  @Override
  public List<String> getContributors() {
    return authors;
  }

  @Override
  public String getTitle() {
    return title;
  }
}
