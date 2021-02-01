package week13d05;

import java.util.HashSet;
import java.util.Set;

public class Chars {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (char c = 'a'; c <= 'z'; c++) {
      sb.append(c);
    }

    System.out.println(sb.toString());
  }

  public int sumOfNotSameChars(String str) {

    Set<Character> characters = new HashSet<>();
    String toProofString = str.toLowerCase();

    for (Character c:toProofString.toCharArray()) {
      if (isValidEnglishChar(c)) {
        characters.add(c);
      }
    }
    return characters.size();
  }

  private boolean isValidEnglishChar(char c) {
    return (c >= 'a' && c <= 'z');
  }
}
