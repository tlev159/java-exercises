package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxValueTest {

  @Test
  public void testMaxValue() {

    Map<Double, Double> coordinates = new HashMap<>();
    coordinates.put(1.0, 2.9);
    coordinates.put(3.0, 4.2);
    coordinates.put(5.4, 5.3);
    coordinates.put(4.0, 7.3);
    coordinates.put(19.2, 10.5);
    coordinates.put(7.5, 10.1);
    coordinates.put(2.6, 16.2);
    coordinates.put(8.3, 1.2);

    MaxValue mm = new MaxValue();

    assertEquals(2.6, mm.MaxOfValues(coordinates));

    assertEquals(8.3, mm.MinOfValues(coordinates));
  }

}
