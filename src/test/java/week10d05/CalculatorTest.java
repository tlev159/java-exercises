package week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void findMinSum() {
    int[] arr = {1, 3, 5, 7, 9};

    assertEquals(16, new Calculator().findMinSum(arr));
  }

  @Test
  void findMinSum2() {
    int[] arr = {9, 7, 1, 3, 5};

    assertEquals(16, new Calculator().findMinSum(arr));
  }
  @Test
  void findMinSum3() {
    int[] arr = {1, 3};

    assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(arr));
  }
}