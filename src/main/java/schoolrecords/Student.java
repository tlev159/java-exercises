package schoolrecords;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {

  private List<Mark> marks = new ArrayList<>();
  private String name;

  public Student(String name) {
    if (isEmpty(name)) {
      throw new IllegalArgumentException("Student name must not be empty!");
    }
    this.name = name;
  }

  public double calculateAverage() { //teljes átlag számolása
    double averge = 0.0;
    double sum = 0.0;
    if (marks.size() > 0) {
      for (int i = 0; i < marks.size(); i++) {
        sum+= marks.get(i).getMarkType().getValue();
      }
      averge = sum / marks.size();
      return Double.parseDouble((new DecimalFormat("##.##").format(averge)).replace(",", "."));
    } else {
      return 0.0;
    }
  }

  public double calculateSubjectAverage(Subject subject) { //tantárgyhoz tartozó átlag számolása
    double subjectAverge = 0.0;
    int quantity = 0;
    double sum = 0.0;
    for (int i = 0; i < marks.size(); i++) {
      if (marks.get(i).getSubject().getSubjectName().equals(subject.getSubjectName())) {
        sum += marks.get(i).getMarkType().getValue();
        quantity++;
      }
    }
    if (quantity == 0) {
      return 0.0;
    }
    subjectAverge = sum / quantity;
    return Double.parseDouble((new DecimalFormat("##.##").format(subjectAverge)).replace(",", "."));
  }

  public boolean equals(Object o) {

    return false;
  }

  public String getName() {
    return name;
  }

  public void grading(Mark m) { // érdemjegy rögzítése
    if (m == null) {
      throw new NullPointerException("Mark must not be null!");
    }
    marks.add(m);
  }

  private boolean isEmpty(String name) {
    if (name == "") {
      return false;
    }
    return true;
  }

  @Override
  public String toString() { //diák szöveges reprezentációja
    return name + " marks: "
            + marks.get(marks.lastIndexOf(marks) + 1).getSubject().getSubjectName()
            + ": "
            + marks.get(marks.lastIndexOf(marks) + 1).toString();
//    return name + " marks: " + marks.get(marks.lastIndexOf(marks) + 1).getSubject().getSubjectName() + ": " + marks.get(0).toString();
//    "Kovács marks: matematika: excellent(5)"
  }
}
