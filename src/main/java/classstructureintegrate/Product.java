package classstructureintegrate;

import java.util.Scanner;

public class Product {

  private String name;
  private int price;

  public Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void increasePrice(int price) {
    this.price += price;
  }

  public void decreasePrice(int price) {
    this.price -= price;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem a termék nevét!");
    String name = scanner.nextLine();
    System.out.println("Kérem a termék árát!");
    int price = scanner.nextInt();

    Product product = new Product(name, price);

    System.out.println("Kérem az áremelés értékét!");
    product.increasePrice(scanner.nextInt());
    System.out.println("Az új ár: " + product.getPrice());

    System.out.println("Kérem, hogy mennyivel csökkentsem a termék árát!");
    product.decreasePrice(scanner.nextInt());
    System.out.println("Az új ár: " + product.getPrice());

  }
}
