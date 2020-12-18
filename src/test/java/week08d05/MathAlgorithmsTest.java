package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgorithmsTest {

  @Test
  public void testGreatestCommonDivisor() {

    MathAlgorithms ma = new MathAlgorithms();

    assertEquals(2, ma.greatestCommonDivisor(6, 8));
    assertEquals(18, ma.greatestCommonDivisor(54, 72));
  }
}
