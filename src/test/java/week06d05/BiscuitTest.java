package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BiscuitTest {

  @Test
  public void testBiscuit() {

  Biscuit b1 = new Biscuit(BiscuitType.LINSER, 150);
  Biscuit b2 = new Biscuit(BiscuitType.KEKS, 240);
  Biscuit b3 = new Biscuit(BiscuitType.CAKE, 300);

  assertEquals("Biscuit type: LINSER (150 g)", b1.toString());
  assertEquals("Biscuit type: KEKS (240 g)", b2.toString());

  Exception ex = assertThrows(IllegalArgumentException.class, () -> new Biscuit(BiscuitType.CAKE, -100));
  assertEquals("A süti tömege nem lehet 1 g-nál kisebb!", ex.getMessage());

  }
}
