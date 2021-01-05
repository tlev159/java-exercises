package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

  @Test
  void getMaxIndex() {
    assertEquals(12, new MaxTravel().getMaxIndex(List.of(12, 12, 0, 1, 3, 5, 7, 6, 7, 12)));
    assertEquals(4, new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4)));
  }
}