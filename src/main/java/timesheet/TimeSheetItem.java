package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private Employee employee;
    private Project project;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (employee == null || project == null) {
            throw new IllegalArgumentException("Wrong employee or project!");
        }
        this.employee = employee;
        this.project = project;
        if (isTheSameDay(beginDate, endDate) && isBeginBeforeEnd(beginDate, endDate)) {
            this.beginDate = beginDate;
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException("Wrong dates!");
        }
    }

    public boolean isTheSameDay(LocalDateTime begin, LocalDateTime end) {
        return begin.toLocalDate().equals(end.toLocalDate());
    }

    public boolean isBeginBeforeEnd(LocalDateTime begin, LocalDateTime end) {
        return begin.isBefore(end);
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}