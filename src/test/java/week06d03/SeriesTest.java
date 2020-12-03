package week06d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeriesTest {

  @Test
  public void testIfA() {

    Series series = new Series(
            new ArrayList<>(Arrays.asList(
            12, 14, 17, 33, 45, 55, 64
    ))
    );
    assertEquals("Növekvő", series.calculateSeriesType());
  }
  @Test
  public void testIfB() {

    Series series = new Series(
            new ArrayList<>(Arrays.asList(
            64, 55, 45, 33, 17, 14, 12
    ))
    );
    assertEquals("Csökkenő", series.calculateSeriesType());
  }
  @Test
  public void testIfC() {

    Series series = new Series(
            new ArrayList<>(Arrays.asList(
            12, 14, 17, 33, 45, 64, 55
    ))
    );
    assertEquals("Össze-vissza", series.calculateSeriesType());
  }

}
