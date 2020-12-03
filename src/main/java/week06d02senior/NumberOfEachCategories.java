package week06d02senior;

public class NumberOfEachCategories {

  private Category category;
  private int number;

  public NumberOfEachCategories(Category category, int number) {
    this.category = category;
    this.number = number;
  }

  public Category getCategory() {
    return category;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "\n" + category + ": " + number + " pieces";
  }
}
