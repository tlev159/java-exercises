package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryItem {

  private String word;
  private List<String> translations = new ArrayList<>();

  public DictionaryItem(String word, List<String> translations) {
    this.word = word;
    addTranslations(translations);
  }

  public void addTranslations(List<String> translation) {
    for (String tw : translation) {
      if (!translations.contains(tw)) {
        translations.add(tw);
      }
    }
  }

  public String getWord() {
    return word;
  }

  public List<String> getTranslations() {
    return translations;
  }
}
