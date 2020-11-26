package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

  private List<Product> products = new ArrayList<>();

  public boolean addProduct(Product product) {
    if (isEmpty(product.getName())) {
      throw new IllegalArgumentException("Product name must be not empty!");
    }
    if (isValidProduct(product)) {
      products.add(product);
      return true;
    }
    return false;
  }

  public int getNumberOfExpired() {
    int numberOfExpiredProducts = 0;
    for (Product product: products) {
      if (product.getDate().isBefore(LocalDate.now())) {
        numberOfExpiredProducts++;
      }
    }
    return numberOfExpiredProducts;
  }

  public boolean isValidProduct(Product product) {
    if (products.contains(product) || product.getDate().isBefore(LocalDate.now())) {
      return false;
    }
    return true;
  }

  public boolean isEmpty(String str) {
    return str == null || "".equals(str);
  }

}
