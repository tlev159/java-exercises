package catalog;

public class SearchCriteria {

  public String title;
  public String contributor;

  private SearchCriteria(String title, String contributor) {
    this.title = title;
    this.contributor = contributor;
  }

  public static SearchCriteria createByBoth(String title, String contributor) {
    if (title == null || contributor == null || "".equals(title) || "".equals(contributor)) {
      throw new IllegalArgumentException();
    }
    return new SearchCriteria(title, contributor);
  }

  public static SearchCriteria createByContributor(String contributor) {
    if (contributor == null || "".equals(contributor)) {
      throw new IllegalArgumentException();
    }
    return new SearchCriteria(null, contributor);
  }

  public static SearchCriteria createByTitle(String title) {
    if (title == null || "".equals(title)) {
      throw new IllegalArgumentException();
    }
    return new SearchCriteria(title,null);
  }


  public boolean hasContributor() {
    if (contributor == null || "".equals(contributor)) {
      return false;
    }
    return true;
  }

  public boolean hasTitle() {
    if (title == null || "".equals(title)) {
      return false;
    }
    return true;
  }

  public String getContributor() {
    return contributor;
  }

  public String getTitle() {
    return title;
  }
}
