package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

  private List<DictionaryItem> dictionaryItems = new ArrayList<>();

  public void addItem(String word, List<String> translations) {
    boolean found = false;
    for (DictionaryItem item : dictionaryItems) {
      if (item.getWord().equals(word)) {
        item.addTranslations(translations);
        found = true;
      }
    }
    if (!found) {
      dictionaryItems.add(new DictionaryItem(word, translations));

    }
  }

  public List<String> findTranslations(String word) {
    for (DictionaryItem transWord : dictionaryItems) {
      if (transWord.getWord().equals(word)) {
        return transWord.getTranslations();
      }
    }
    return new ArrayList<>();
  }

}
