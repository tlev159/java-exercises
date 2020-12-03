package week06d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

  private Budget budget = new Budget(Arrays.asList(
          new Item(1100, LocalDate.of(2020, 5, 25), "banana"),
          new Item(1200, LocalDate.of(2020, 6, 10), "mandarine"),
          new Item(1300, LocalDate.of(2020, 3, 3), "orange"),
          new Item(1400, LocalDate.of(2020, 5, 7), "apple")
  ));

  @Test
  public void testItem() {

    List<Item> results = budget.getItemsByMonth(5);


    assertEquals(2, results.size());
    assertEquals("banana", results.get(0).getName());
    assertEquals(1400, results.get(1).getPrice());

  }


}
