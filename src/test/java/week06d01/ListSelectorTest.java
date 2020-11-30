package week06d01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

  ListSelector ls = new ListSelector();

  @Test
  public void getEvenIndexElementsTest() {

    assertEquals("[almabarack]", ls.selectFromList(Arrays.asList("alma", "körte", "barack")));
  }

  @Test
  public void getEvenElementsWithNullTest() {

    assertThrows(IllegalArgumentException.class, () -> ls.selectFromList(null));
  }
}
