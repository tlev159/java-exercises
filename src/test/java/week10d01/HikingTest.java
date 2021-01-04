package week10d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingTest {

  @Test
      public void testGetPlusElevation() {

    List<Double> hiking = new ArrayList<>(Arrays.asList(10.0, 20.0, 15.0, 18.0));

    Hiking h = new Hiking(1.1, 2.2, 0.0);


    assertEquals(13, h.getPlusElevation(hiking));

  }
}
