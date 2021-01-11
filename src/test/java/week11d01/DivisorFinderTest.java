package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

  @Test
  void findDivisors() {
    assertEquals(2, new DivisorFinder().findDivisors(1425));
    assertEquals(2, new DivisorFinder().findDivisors(3501));
  }

  @Test
  void findDivisorsException() {
    assertThrows(IllegalArgumentException.class, () -> new DivisorFinder().findDivisors(0));
  }
}