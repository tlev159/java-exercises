package week13d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

  public String merge(Path file, List<Employee> employees) {
    StringBuilder sb = new StringBuilder();
    try {
      String pattern = Files.readString(file);
      for (Employee employee:employees) {
        String editedStringLine = changeStrings(pattern, employee);
        sb.append(editedStringLine + "\n");
      }
      return sb.toString();
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }
  }

  private String changeStrings(String pattern, Employee employee) {
    String year = Integer.toString(employee.getYearOfBirth());
    pattern.replace("{nev}", employee.getName());
    pattern.replace("{ev}", year);
    return pattern;
  }
}
