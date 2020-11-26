package week05d04senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

  @Test
  public void testCurrencyIsNotInList() {
    week05d04senior.Product product = new week05d04senior.Product(150, "HUF");

    assertEquals(0.5, Math.round(product.convertCurrency("USD") * 100.0) / 100.0);
  }

}
