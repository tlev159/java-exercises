package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSheetItem {

  private String employee;
  private String project;
  private LocalDateTime from;
  private LocalDateTime to;

  public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
    this.employee = employee;
    this.project = project;
    this.from = from;
    this.to = to;
  }

  public TimeSheetItem(TimeSheetItem timeSheetItem) {
    this.employee = timeSheetItem.employee;
    this.project = timeSheetItem.project;
    this.from = timeSheetItem.from;
    this.to = timeSheetItem.to;
  }

  public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate) {
    TimeSheetItem anotherTimeSheetItem = new TimeSheetItem(timeSheetItem);
    anotherTimeSheetItem.from = LocalDateTime.of(localDate, anotherTimeSheetItem.from.toLocalTime());
    anotherTimeSheetItem.to = LocalDateTime.of(localDate, anotherTimeSheetItem.to.toLocalTime());
    return anotherTimeSheetItem;
  }

  public String getEmployee() {
    return employee;
  }

  public void setEmployee(String employee) {
    this.employee = employee;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public LocalDateTime getFrom() {
    return from;
  }

  public void setFrom(LocalDateTime from) {
    this.from = from;
  }

  public LocalDateTime getTo() {
    return to;
  }

  public void setTo(LocalDateTime to) {
    this.to = to;
  }
}
