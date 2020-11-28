package stringbuilder;

public class PalindromeValidator {

  public boolean isPalindrome(String word) {
    if (word == null) {
      throw new IllegalArgumentException("Text must not be null!");
    }
    StringBuilder reverseWord = new StringBuilder(word.trim().toLowerCase()).reverse();
    return word.trim().toLowerCase().equals(reverseWord.toString());
  }
}
