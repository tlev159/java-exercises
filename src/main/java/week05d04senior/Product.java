package week05d04senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Product {

  private long price;
  private String curr;
//  private List<Currency> currencies = new ArrayList<>();


  public Product(long price, String curr) {
    this.price = price;
    this.curr = curr;
  }

  public double convertCurrency(String cur) {
    double cR = Currency.valueOf(cur).getChangingRate();
    return price * cR;
  }

  public boolean isEmpty(String str) {
    return (str == null || "".equals(str));
  }

  public static void main(String[] args) {
    Product product = new Product(150, "HUF");
    System.out.println(Math.round(product.convertCurrency("USD")*100.0)/100.0);
  }
}
