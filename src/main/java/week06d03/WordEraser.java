package week06d03;

public class WordEraser {

  private String words;
  private String word;

  public String eraseWord(String words, String word) {
    String[] w2 = words.split(" ");
    StringBuilder wordsWithoutWord = new StringBuilder();
    for (String w: w2) {
      if (!word.equals(w)) {
        wordsWithoutWord.append(w).append(" ");
      }
    }
    return wordsWithoutWord.toString().trim();
  }
}
