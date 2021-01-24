package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

  private List<String> salaries = new ArrayList<>();

  public SalaryWriter(List<String> salaries) {
    if (salaries == null) {
      throw new IllegalArgumentException("List is invalid!");
    }
    this.salaries = salaries;
  }

  public void writeNamesAndSalaries(Path file) {
    List<String> lines = makeLinse();
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){
      for (String s:lines) {
        writer.println(s);
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!");
    }
  }

  private List<String> makeLinse() {
    List<String> line = new ArrayList<>();
    for (String name:salaries) {
      switch (name.split(" ")[0]) {
        case "Dr.":
          line.add(name + ": " + 500_000);
          break;
        case "Mr.":
        case "Mrs.":
          line.add(name + ": " + 200_000);
          break;
        default:
          line.add(name + ": " + 100_000);
      }
    }
    return line;
  }

  public List<String> getSalaries() {
    return salaries;
  }
}
