package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

  public int readAndSumValues(String intString, String delimiter) {
    try (Scanner scanner = new Scanner(intString)) {
      if (!isEmpty(delimiter)) {
        scanner.useDelimiter(delimiter);
      }
      return sumValuesWithScanner(scanner);
    }
  }

  public int sumValuesWithScanner(Scanner scan) {
    int sum = 0;
    try {
      while (scan.hasNext()) {
        sum += scan.nextInt();
      }
    } catch (InputMismatchException imex) {
      throw new IllegalArgumentException("Incorrect parameter string!", imex);
    }
    return sum;
  }

  public int readAndSumValues(String intString) {
    return readAndSumValues(intString, null);
  }

  public String filterLinesWithWordOccurrences(String text, String word) {
    if (isEmpty(text) || word == null || "".equals(word)) {
      throw new IllegalArgumentException("Incorrect parameter string!");
    }
    try (Scanner scanner = new Scanner(text)) {
      StringBuilder sb = new StringBuilder();
      while (scanner.hasNextLine()) {
        String l = scanner.nextLine();
        if (l.contains(word)) {
          sb.append(l).append("\n");
        }
      }
      return sb.toString().trim();
    }
  }

  public boolean isEmpty(String str) {
    return str == null || "".equals(str.trim());
  }
}
