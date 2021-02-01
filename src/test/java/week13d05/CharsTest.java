package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharsTest {

  @Test
  public void testCharCounter() {

    Chars chars = new Chars();
    String str1 = "valami";
    String str2 = "árvíztűrő";

    assertEquals(5, chars.sumOfNotSameChars(str1));
    assertEquals(4, chars.sumOfNotSameChars(str2));
  }
}
