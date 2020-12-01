package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

  @Test
  public void getProductByCategoryNameTest() {

    Store store = new Store(Arrays.asList(
            new Product("sültkrumpli", Category.FROZEN, 1200),
            new Product("fagyasztott zöldség", Category.FROZEN, 1100),
            new Product("kenyér", Category.BAKEDGOODS, 560),
            new Product("felmosószivacs", Category.OTHER, 1400),
            new Product("mosogatószer", Category.OTHER, 200),
            new Product("felmosó készlet", Category.OTHER, 5600)
    ));

    assertEquals(2, store.getProductByCategoryName(Category.FROZEN));
    assertEquals(3, store.getProductByCategoryName(Category.OTHER));
  }
}
