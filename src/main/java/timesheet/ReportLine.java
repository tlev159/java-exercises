package timesheet;

public class ReportLine {

  private Project projectName;
  private long time;

  public ReportLine(Project projectName, long time) {
    this.projectName = projectName;
    this.time = time;
  }

  public Project getProjectName() {
    return projectName;
  }

  public long getTime() {
    return time;
  }

  @Override
  public String toString() {
    return projectName + "\t" + time;
  }
}