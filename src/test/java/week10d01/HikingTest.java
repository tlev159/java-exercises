package week10d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HikingTest {

  @Test
      public void testGetPlusElevation() {

    List<Double> hiking = new ArrayList<>(Arrays.asList(10.0, 20.0, 15.0, 18.0));
    List<Double> hiking2 = new ArrayList<>(Arrays.asList(13.0));

    assertEquals(13.0, new Hiking().getPlusElevation(hiking));
    assertEquals(0.0, new Hiking().getPlusElevation(hiking2));
//    assertEquals(0.0, new Hiking().getPlusElevation());
    assertEquals(5.0, new Hiking().getPlusElevation(List.of(12.0, 13.0, 11.0, 15.0)));
//    assertThrows(IllegalArgumentException.class new Hiking().getPlusElevation(null));

  }
}
