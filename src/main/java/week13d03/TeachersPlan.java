package week13d03;

public class TeachersPlan {

  private String name;
  private String subject;
  private String className;
  private int hoursPerWeek;

  public TeachersPlan(String name, String subject, String className, int hoursPerWeek) {
    this.name = name;
    this.subject = subject;
    this.className = className;
    this.hoursPerWeek = hoursPerWeek;
  }

  public String getName() {
    return name;
  }

  public String getSubject() {
    return subject;
  }

  public String getClassName() {
    return className;
  }

  public int getHoursPerWeek() {
    return hoursPerWeek;
  }

  @Override
  public String toString() {
    return "TeachersPlan{" +
            "name='" + name + '\'' +
            ", subject='" + subject + '\'' +
            ", className='" + className + '\'' +
            ", hoursPerWeek=" + hoursPerWeek +
            '}';
  }
}
