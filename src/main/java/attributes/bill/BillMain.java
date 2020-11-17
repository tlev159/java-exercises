package attributes.bill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BillMain {

  public static void main(String[] args) {
    Bill bill = new Bill();

    bill.addItem(new Item("egér", 3, 1200));
    bill.addItem(new Item("egérke", 2, 1000));
    bill.addItem(new Item("fehér egér", 1, 1010));
    bill.addItem(new Item("barna egér", 2, 1201));
    bill.addItem(new Item("szürke egér", 3, 1200));

    System.out.println(bill.calculateTotalPrice());
  }
}
