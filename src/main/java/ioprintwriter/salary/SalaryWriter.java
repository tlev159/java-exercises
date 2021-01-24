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
    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){
      for (String s:salaries) {
        writer.print(s);
        writer.print(": ");
        writer.println(addSalary(s));
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!");
    }
  }

  private String addSalary(String name) {
      switch (name.split(" ")[0]) {
        case "Dr.":
          return "500000";
        case "Mr.":
        case "Mrs.":
          return "200000";
        default:
          return "100000";
      }
  }

  public List<String> getSalaries() {
    return salaries;
  }
}
