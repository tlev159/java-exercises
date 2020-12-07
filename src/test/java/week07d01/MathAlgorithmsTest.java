package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static week07d01.MathAlgorithms.isPrime;

public class MathAlgorithmsTest {

  @Test
  public void testIsPrime() {

    assertTrue(isPrime(7));
    assertTrue(isPrime(2));
    assertFalse(isPrime(4));
    assertTrue(isPrime(5));
    assertTrue(isPrime(3));
    assertTrue(isPrime(11));
    assertTrue(isPrime(13));
    assertFalse(isPrime(15));
  }
}
