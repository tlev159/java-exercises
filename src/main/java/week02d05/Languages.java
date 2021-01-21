package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

  public static void main(String[] args) {

    List<String> progLanguages = new ArrayList<>();

    progLanguages.add("Java");
    progLanguages.add("Python");
    progLanguages.add("JavaScript");

    for (String language:progLanguages) {
      if (language.length() > 5) {
        System.out.println(language);
      }
    }
  }
}