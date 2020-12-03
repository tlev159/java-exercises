package week06d02senior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

  Store store = new Store(Arrays.asList(
          new Product("kifli", Category.BAKEDGOODS, 90),
          new Product("zsemle", Category.BAKEDGOODS, 87),
          new Product("felmosóvödör", Category.OTHER, 900),
          new Product("jégkrém", Category.FROZEN, 980),
          new Product("sültkrumpli", Category.FROZEN, 1200),
          new Product("zöldségkeverék", Category.FROZEN, 1150)
  ));

  @Test
  public void testGetProductsByCategory() {
    List<NumberOfEachCategories> n = new ArrayList<>();
    n.add(new NumberOfEachCategories(Category.BAKEDGOODS, 2));
    n.add(new NumberOfEachCategories(Category.OTHER, 1));
    n.add(new NumberOfEachCategories(Category.FROZEN, 3));

    assertEquals(2, store.getProductsByCategory().get(0).getNumber());

  }
}
