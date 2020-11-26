package week05d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StoreTest {

  @Test
  public void testAddProduct() {
    Product products = new Product("kenyér", 2020,11, 27);

    assertEquals("kenyér", products.getName());
    assertEquals("2020-11-27", products.getDate().toString());
  }

  @Test
  public void testAddProductWithEmptyName() {
    Store store = new Store();

    Exception ex = assertThrows(IllegalArgumentException.class, () -> store.addProduct(new Product("", 2020,11, 27)));
    assertEquals("Product name must be not empty!", ex.getMessage());

  }

  @Test
  public void testStore() {
    Product product1 = new Product("tej", 2020, 12, 31);
    Product product2 = new Product("élesztő", 2020, 11, 11);
    Product product3 = new Product("sajt", 2020, 11, 25);
    Product product4 = new Product("szalámi", 2019, 12, 31);
    Product product5 = new Product("sólett konzerv", 2025, 12, 31);
//    Store store = new Store(new ArrayList<>(new Product("tej", 2020, 12, 31));

//    assertEquals(3, store.getNumberOfExpired());
  }

}
