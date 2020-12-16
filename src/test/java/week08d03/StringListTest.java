package week08d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListTest {

  @Test
  public void testStringListUnion() {

  List<String> first = new ArrayList<>(Arrays.asList("a", "b", "c"));
  List<String> second = new ArrayList<>(Arrays.asList("a", "d"));

  StringList sl = new StringList();

  assertEquals("c", sl.stringListsUnion(first, second).get(2));
  }

}
