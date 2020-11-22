package schoolrecords;

public class StudyResultByName {

  private String studentName;
  private double studyAverage;

  public StudyResultByName(double studyAverage, String studentName) {
    this.studyAverage = studyAverage;
    this.studentName = studentName;
  }

  public String getStudentName() {
    return studentName;
  }

  public double getStudyAverage() {
    return studyAverage;
  }

}
