package week02d03;

public class Product {
  private String name;
  private String code;

  public Product(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {

    return name;
  }

  public String getCode() {

    return code;
  }

  public boolean areTheyEqual(Product p) {
    if (Math.abs(code.length() - p.code.length()) <= 1) {
      return name.equals(p.name);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Product product1 = new Product("kabát","12345");
    Product product2 = new Product("kabát","1234564");
    Product product3 = new Product("cipő","12346");

    System.out.println(product1.getName());
    System.out.println(product1.getCode());

    System.out.println("A két termék megegyezik-e: " + product2.areTheyEqual(product1));
  }

}