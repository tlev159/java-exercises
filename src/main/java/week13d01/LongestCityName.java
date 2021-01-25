package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LongestCityName {

  private static final String SEP = ";";
  private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  public String findLongestCityNameFromFile(String pathString) {
    String f = "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + pathString;
    Path file = Path.of(f);
    String longestCityNameIs = "";
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] temp = line.split(SEP);
        if (temp[1].trim().length() > longestCityNameIs.length()) {
          longestCityNameIs = temp[1].trim();
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!");
    }
    return longestCityNameIs;
  }
}
