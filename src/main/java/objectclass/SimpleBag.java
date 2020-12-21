package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

  private List<Object> items = new ArrayList<>();
  private int cursor = 0;

  public SimpleBag() {
    this.items = items;
  }

  public void putItem(Object item) {
    items.add(item);
  }

  public boolean isEmpty() {
    if (items == null || items.size() < 1) {
      return true;
    }
    return false;
  }

  public int size() {
    return items.size();
  }

  public void beforeFirst() {
    cursor = 0;
  }

  public boolean hasNext() {
    if (cursor < items.size() - 1) {
      cursor++;
      return true;
    }
    return false;
  }

  public Object next() {
    return items.get(cursor);
  }

  public boolean contains(Object item) {
    int i = 0;
    while (i < items.size()) {
      if ( items.get(i).toString().equals(item.toString())) {
        return true;
      }
      i++;
    }
    return false;
  }

  public int getCursor() {
    return cursor;
  }

}
