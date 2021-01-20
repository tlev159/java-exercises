package week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberStat {

  private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  private List<Integer> numbers = new ArrayList<>();

  public int lowestPresentInList(String pathString) {
    numbersToList(pathString);
    Collections.sort(numbers);
    int result = numbers.get(0);
    int sumOf = numbers.size();
    for (Integer n:numbers) {
      int sum = 0;
      for (int i = 0; i < numbers.size(); i++) {
        if (n == numbers.get(i)) {
          sum++;
        }
      }
      if (sum < sumOf) {
        sumOf = sum;
        result = n;
      }
    }
    return result;
  }

  public void numbersToList(String pathString) {
  String pathOfFile = "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + pathString;
  Path file = Path.of(pathOfFile);
  readNumbersFromFile(file);
  }

  private void readNumbersFromFile(Path file) {
    try (BufferedReader reader = Files.newBufferedReader(file)){
      String line;
      while ((line = reader.readLine()) != null) {
        numberSeparator(line);
      }
    }
    catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!");
    }
  }

  public void numberSeparator(String line) {
    String[] nums = line.split(",");
    for (String s:nums) {
      try {
        numbers.add(Integer.parseInt(s));
      }
      catch (IllegalArgumentException iae) {
        throw new IllegalArgumentException("Wrong number!");
      }
    }
  }

}
