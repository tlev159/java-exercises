package objectclass;

public class Beer {

  private String name;
  private int price;

  public Beer(String name, int price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return name + ", " + price;
  }
}
