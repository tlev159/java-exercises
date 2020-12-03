package week06d02senior;

import java.util.ArrayList;
import java.util.List;

public class Store {

  List<Product> products = new ArrayList<>();

  public Store(List<Product> products) {
    this.products = products;
  }

  public List<NumberOfEachCategories> getProductsByCategory() {
    List<NumberOfEachCategories> result = fillCategories();
      int count = 0;
      int i = 0;
    for (NumberOfEachCategories noec:result) {
      for (Product p: products) {
        if (noec.getCategory() == p.getCategory()) {
          count++;
        }
      }
      result.get(i).setNumber(count);
      count = 0;
      i++;
    }
    System.out.println(result);
    return result;
  }

  public List<NumberOfEachCategories> fillCategories() {
    List<NumberOfEachCategories> c = new ArrayList<>();
    for (Product p : products) {
        if (addToList(p, c)) {
          c.add(new NumberOfEachCategories(p.getCategory(), 0));
      }
    }
    return c;
  }

  public boolean addToList(Product p, List<NumberOfEachCategories> categories) {
    boolean isAdded = false;
    for (NumberOfEachCategories cat: categories) {
      if (cat.getCategory() == p.getCategory()) {
        isAdded = true;
      }
    }
    return isAdded;
  }
}
