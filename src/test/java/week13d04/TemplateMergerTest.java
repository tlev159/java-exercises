package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

  private static final String SEPARATE = FileSystems.getDefault().getSeparator();

  TemplateMerger tm = new TemplateMerger();

  @Test
  public void testEmployee() {

    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee("John Doe", 1980));
    employees.add(new Employee("Jane Doe", 1990));

    String fileName = "patternFile.txt";
    String path = "src" + SEPARATE + "main" + SEPARATE + "resources" + SEPARATE + fileName;
    Path file = Path.of(path);
    System.out.println(tm.merge(file, employees));

  }
}