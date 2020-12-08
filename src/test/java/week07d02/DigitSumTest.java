package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

  @Test
  public void DigitSumTest() {
    DigitSum ds = new DigitSum();

    assertEquals(6, ds.sumOfDigits(123));
    assertEquals(11, ds.sumOfDigits(1235));
    assertEquals(11, ds.sumOfDigits(-1235));
  }
}
