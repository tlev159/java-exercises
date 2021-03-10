package week06d04senior;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

  @Test
  public void testAddItemWithEmptyNameThrows() {

    ShoppingCart shoppingCart = new ShoppingCart();

    assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("",12));

  }

  @Test
  public void testAddItemWithNoQuantity() {

    ShoppingCart shoppingCart = new ShoppingCart();

    assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("Kenyér",0));

  }

  @Test
  public void testAddItem() {

    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addItem("Kenyér",2);
    shoppingCart.addItem("Tej",6);
    shoppingCart.addItem("Tej",6);

    assertEquals(2, shoppingCart.getItems().size());
    assertEquals(12, shoppingCart.getItems().get(1).getQuantity());
  }

  @Test
  public void testGetItem() {
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addItem("Kenyér",2);
    shoppingCart.addItem("Tej",6);

    assertEquals(6, shoppingCart.getItem("Tej"));
    assertEquals(0, shoppingCart.getItem("Vaj"));

    shoppingCart.addItem("Tej",6);
    assertEquals(12, shoppingCart.getItem("Tej"));

  }
}