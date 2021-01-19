package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

  private String name;

  private List<Integer> gradeList = new ArrayList<>();

  public Student(String name, List<Integer> gradeList) {
    this.name = name;
    this.gradeList = gradeList;
  }

  public double average() {
    double sum = 0.0;
    for (Integer grade:gradeList) {
      sum += grade;
    }
    return (sum / gradeList.size());
  }

  public boolean isIncreasing() {
    double actual = gradeList.get(0);
    for (Integer gr:gradeList) {
      if (actual > gr) {
        return false;
      }
      actual = gr;
    }
    return true;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getGradeList() {
    return new ArrayList<>(List.copyOf(gradeList));
  }
}
