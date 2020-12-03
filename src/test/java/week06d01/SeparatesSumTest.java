package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparatesSumTest {

  @Test
  public void testSeparatesSum() {

    String s = "-12,2;6,3;-7,8;3,7";

    SeparatesSum sepS = new SeparatesSum();

    assertEquals(-20, sepS.sum(s).get(0));
    assertEquals(10, sepS.sum(s).get(1));

  }
}
