package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

  List<Item> items = new ArrayList<>();

  public Budget(List<Item> items) {
    this.items = items;
  }

  public List getItemsByMonth(int month) {
    List<Item> buydInGivenMonth = new ArrayList<>();
    for (Item i : items) {
      if (i.getDate().getMonthValue() == month) {
        buydInGivenMonth.add(i);
      }
    }
    return buydInGivenMonth;
  }
}
