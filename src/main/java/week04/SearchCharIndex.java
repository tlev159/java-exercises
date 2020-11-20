package week04;

import java.util.ArrayList;
import java.util.List;

public class SearchCharIndex {

  public static void main(String[] args) {
    SearchCharIndex searchCharIndex = new SearchCharIndex();

    System.out.println(getIndexesOfChar("ketchup", 'e'));
    System.out.println(getIndexesOfChar("kefe", 'e'));
  }

  static List<Integer> getIndexesOfChar(String str, char c) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == c ) {
        result.add(i);
      }
    }
    return result;
  }

}
