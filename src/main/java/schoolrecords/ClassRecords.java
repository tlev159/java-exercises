package schoolrecords;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

  private String className;
  private Random rnd = new Random();
  private List<Student> students = new ArrayList<>();

  public ClassRecords(String className, Random rnd) {
    if (isEmpty(className)) {
      throw new IllegalArgumentException("Classname can't be empty!");
    } else {
      this.className = className;
      this.rnd = rnd;
    }
  }

  public boolean addStudent(Student student) { //felvesz egy diákot az osztályba
    boolean isntExists = true;
      for (Student oneStudent : students) {
        if (oneStudent.getName().equals(student.getName())) {
          isntExists = false;
        }
      }
        if (isntExists) {
          students.add(student);
        }
    return isntExists;
  }

  public double calculateClassAverage() { //osztályátlagot számol, minden diákot figyelembe véve
    double classAverage = 0.0;
    double sumOfMarks = 0.0;
    if (students.size() == 0) {
      throw new ArithmeticException("No student in the class, average calculation aborted!");
    }
    for (int i = 0; i < students.size(); i++) {
      sumOfMarks+= students.get(i).calculateAverage();
    }
    if (sumOfMarks == 0.0) {
      throw new ArithmeticException("No marks present, average calculation aborted!");
    } else {
      classAverage = sumOfMarks / students.size();
      return Double.parseDouble((new DecimalFormat("##.##").format(classAverage)).replace(",", "."));
    }
  }

  public double calculateClassAverageBySubject(Subject subject) { //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    double classAverageBySubject = 0.0;
    double sumOfSubjectMarks = 0.0;
    int toDivideWith = 0;
    for (int i = 0; i < students.size(); i++) {
      sumOfSubjectMarks+= students.get(i).calculateSubjectAverage(subject);
//      System.out.println(i + ".: " + students.get(i).calculateSubjectAverage(subject));
      if (students.get(i).calculateSubjectAverage(subject) > 0.0) {
        toDivideWith++;
//        System.out.println("toDivi...:" + toDivideWith);
      }
    }
      classAverageBySubject = sumOfSubjectMarks / toDivideWith;
      return Double.parseDouble((new DecimalFormat("##.##").format(classAverageBySubject)).replace(",", "."));
  }

  public Student findStudentByName(String name) { // név szerint megkeres egy diákot az osztályban
    int indexOfSearchedStudent = -1;

    if (name.equals("")) {
      throw new IllegalArgumentException("Student name must not be empty!");
    }
    if (students.size() < 1) {
      throw new IllegalStateException("No students to search!");
    }
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getName().equals(name)) {
        indexOfSearchedStudent = i;
      }
    }
    if (indexOfSearchedStudent < 0) {
      throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    } else {
      return students.get(indexOfSearchedStudent);
    }
  }

  public String getClassName() {
    return className;
  }

  private boolean isEmpty(String className) {
    if (className.equals("")){
      return false;
    }
    return true;
  }

  public String listStudentNames() { //kilistázza a diákok neveit, vesszővel elválsztva
    String studentNames = "";
    for (int i = 0; i < students.size() -1 ; i++) {
      studentNames += students.get(i).getName() + ", ";
    }
    studentNames += students.get(students.size()-1).getName();
    return studentNames;
  }

  public List<StudyResultByName> listStudyResults() { // a diákok nevét és tanulmányi átlagát egy-egy
//  új objektumba viszi és azok listáját adja vissza
    List<StudyResultByName> list = new ArrayList<StudyResultByName>();
    for (int i = 0; i < students.size(); i++) {
      double average = students.get(i).calculateAverage();
      String name = students.get(i).getName();
      list.add(new StudyResultByName(average, name));
    }
    return list;
  }

  public boolean removeStudent(Student student) { //kivesz egy diákot az osztályból
    boolean remStu = false;
    int indexOfToRemoveStudent = -1;
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getName().equals(student.getName())) {
        indexOfToRemoveStudent = i;
      }
    }
    if (indexOfToRemoveStudent >= 0) {
      remStu = true;
      students.remove(indexOfToRemoveStudent);
    }
    return remStu;
  }

  public Student repetition() { //felelethez a listából random módon kiválaszt egy diákot
    int indexOfStudentForRepetition = -1;
    if (students.size() < 1) {
      throw new IllegalStateException("No students to select for repetition!");
    }
    indexOfStudentForRepetition = rnd.nextInt(students.size());
    return students.get(indexOfStudentForRepetition);
  }

}
