package week05d04senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

  @Test
  public void testConvertPrice() {

    Product product = new Product(150, "HUF");
    assertEquals(0.5, product.convertPrice("USD"));
    assertEquals(45000.0, product.convertPrice("HUF"));

  }
}