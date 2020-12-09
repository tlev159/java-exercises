package week07d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

  @Test
  public void testNumberList() {

  NumberList nl = new NumberList();

  assertTrue(nl.inIncreasing(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
  assertTrue(nl.inIncreasing(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 5))));
  assertFalse(nl.inIncreasing(new ArrayList<>(Arrays.asList(1, 2, 4, 3, 4, 5, 6, 7))));
  }
}
