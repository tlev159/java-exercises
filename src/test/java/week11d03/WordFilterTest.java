package week11d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

  @Test
  void wordsWithChar() {
    List<String> list = new ArrayList<>(Arrays.asList(
            "abce", "ceftc", "actgrs", "abde"
    ));

    List<String> result = new ArrayList<>(Arrays.asList(
            "abce", "ceftc", "actgrs"
    ));

    assertEquals(result, new WordFilter().wordsWithChar(list, 'c'));
  }
}