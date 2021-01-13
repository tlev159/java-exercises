package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

  public List<String> wordsWithChar(List<String> words, char c) {
    if (words == null || "".equals(c)) {
      throw new IllegalArgumentException("Not valid arguments!");
    }
    List<String> result = new ArrayList<>();
    for (String s:words) {
      boolean isInclude = false;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == c) {
          isInclude = true;
        }
      }
      if (isInclude) {
        result.add(s);
      }
    }
    return result;
  }
}
