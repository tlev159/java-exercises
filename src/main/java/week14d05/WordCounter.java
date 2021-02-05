package week14d05;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WordCounter {

  public Map<String, Integer> countWord(BufferedReader br, String... words) {
    Map<String, Integer> searchedWords = fillMap(words);
    try {
      String line;
      while ((line = br.readLine()) != null) {
        for (String word : words) {
          if (line.toLowerCase().contains(word.toLowerCase())) {
            int count = searchedWords.get(word);
            searchedWords.put(word, count + 1);
          }
        }
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Error at reading!", ioe);
    }
    return searchedWords;
  }

  private Map<String, Integer> fillMap(String[] words) {
    Map<String, Integer> result = new HashMap<>();
    for (String word:words) {
        result.put(word, 0);
    }
    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/week14d05/hachiko.srt"), Charset.forName("windows-1250"))){
      WordCounter hackiko = new WordCounter();
      System.out.println(hackiko.countWord(reader, "Hachiko", "pályaudvar", "jó", "haza"));
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }

}
