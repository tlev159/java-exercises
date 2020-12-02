package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {

  @Test
  public void wordEraserTest() {

    WordEraser w = new WordEraser();

    assertEquals("körte barack szilva körte birsalma", w.eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
  }
}
