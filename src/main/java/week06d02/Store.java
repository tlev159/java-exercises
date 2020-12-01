package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

  private List<Product> products = new ArrayList<>();

  public Store(List<Product> products) {
    this.products = products;
  }

  public int getProductByCategoryName(Category category) {
    int sum = 0;
    for (Product product:products) {
      if (product.getCategory() == category) {
        sum++;
      }
    }
    return sum;
  }
}
