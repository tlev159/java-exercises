package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {

  private List<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    this.items.add(item);
  }

  public double calculateTotalPrice() {
    double sum = 0;
    for (int i = 0; i < items.size(); i++) {
      sum += getItems().get(i).getPrice() * getItems().get(i).getQuantity();
    }
    return sum;
  }

  public List<Item> getItems() {
    return items;
  }
}
