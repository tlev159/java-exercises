package week06d04senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  List<Item> items = new ArrayList<>();

  public void addItem(String name, int quantity) {
    if (name.isEmpty() || quantity <= 0) {
      throw new IllegalArgumentException("Wrong params!");
    }
    int index = getIndex(name);
    if (index == -1) {
      items.add(new Item(name, quantity));
    } else {
      items.get(index).setQuantity(quantity);
    }
  }

  private int getIndex(String name) {
    for (Item item:items) {
      if (item.getName().equals(name)) {
        return items.indexOf(item);
      }
    }
    return -1;
  }

  public int getItem(String name) {
    int index = getIndex(name);
    return index == -1 ? 0 : items.get(index).getQuantity();
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }
}
