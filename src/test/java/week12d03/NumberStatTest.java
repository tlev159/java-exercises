package week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

  @Test
  void lowestPresentInList() {

    NumberStat ns = new NumberStat();

    assertEquals(3, ns.lowestPresentInList("numberstat.txt"));
    assertEquals(3, ns.lowestPresentInList("numberstat2.txt"));
  }
}