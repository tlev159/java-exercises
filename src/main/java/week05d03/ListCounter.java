package week05d03;

import java.util.List;

public class ListCounter {

  public int counter(List<String> list) {
    int sumOfWords = 0;
    for (String each:list) {
      String firstChar = each.substring(0, 1);
      if (firstChar.toLowerCase().equals("a")) {
        sumOfWords++;
      }
    }
    return sumOfWords;
  }
}
