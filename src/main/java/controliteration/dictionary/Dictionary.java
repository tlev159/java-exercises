package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

  private List<DictionaryItem> dictionaryItems = new ArrayList<>();

  public void addItem(String word, List<String> translations) {
    if(dictionaryItems.size() == 0) {
      dictionaryItems.add(new DictionaryItem(word, translations));
    } else {
      for (DictionaryItem item : dictionaryItems) {
        if (item.getWord().contains(word)) {
          item.addTranslations(translations);
        }
      }
    }
  }

  public List<String> findTranslations(String word) {
    List<String> foundedTranslaions = new ArrayList<>();
    for (DictionaryItem item : dictionaryItems) {
      if (item.getWord().contains(word)) {
        for (String translation: item.getTranslations()) {
          foundedTranslaions.add(translation);
        }
      }
    }
    System.out.println(foundedTranslaions);
    return foundedTranslaions;
  }
}
