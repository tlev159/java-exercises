package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

  public static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  private List<Student> students = new ArrayList<>();

  public void readGradesFromFile(String pathString) {
    Path file = Path.of("src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + pathString);
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while((line = reader.readLine()) != null) {
        String[] student = line.split(" ");
        List<Integer> grades = makeNewStudentGradeList(student);
        students.add(new Student(student[0], grades));
      }
    }
    catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }
  }

  private List<Integer> makeNewStudentGradeList(String[] stud) {
    List<Integer> studentGrades = new ArrayList<>();
    for (int i = 1; i < stud.length; i++) {
      studentGrades.add(Integer.parseInt(stud[i]));
    }
    return studentGrades;
  }

  public double classAverage() {
    double result = 0.0;
    for (Student s:students) {
      result += s.average();
    }
    return result / students.size();
  }

  public List<Student> getStudents() {
    return students;
  }
}
