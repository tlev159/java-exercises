package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNoteBook {

  private List<Student> students;

  public ClassNoteBook(List<Student> students) {

    this.students = students;
  }

  public List<Student> sortNoteBook() {
    List<Student> result = new ArrayList<>(students);
    Collections.sort(result);
    return result;
  }

  public List<Student> getStudents() {
    return students;
  }
}
