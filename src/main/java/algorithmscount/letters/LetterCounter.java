package algorithmscount.letters;

public class LetterCounter {

  private String text;
  private char searchedChar;

  public int countLetters(String text, char searchedChar) {
    int count = 0;
//    String[] splittedText = text.;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == searchedChar) {
        count++;
      }
    }
    return count;
  }
}
