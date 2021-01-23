package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

  private List<Employee> employees = new ArrayList<>();
  private List<Project> projects = new ArrayList<>();
  private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

  public Company(InputStream employeesFile, InputStream projectsFile) {
    try (BufferedReader brEmployee = new BufferedReader(new InputStreamReader(employeesFile));
         BufferedReader brProject = new BufferedReader(new InputStreamReader(projectsFile))) {
      String line1;
      String line2;
      while ((line1 = brEmployee.readLine()) != null) {
          employees.add(new Employee(line1.split(" ")[0], line1.split(" ")[1]));
      }
      while ((line2 = brProject.readLine()) != null) {
          projects.add(new Project(line2));
      }
    } catch (IOException e) {
      throw new IllegalStateException("Can not read file!", e);
    }
  }

  public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
    timeSheetItems.add((new TimeSheetItem(employee, project, beginDate, endDate)));
  }

  public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
    if (!isEmployeeInTheEmployeeList(employeeName)) {
      throw new IllegalArgumentException("Wrong employee name!");
    } else {
      List<ReportLine> reportLine = new ArrayList<>();
      for (Project p : projects) {
        reportLine.add(new ReportLine(p, projectTime(p.getName(), employeeName, year, month)));
      }
//      System.out.println(reportLine.size());
//      for (ReportLine r:reportLine) {
//        System.out.println(r.getProjectName().getName() + ": " + r.getTime());
//      }
      return reportLine;
    }
  }

  private boolean isEmployeeInTheEmployeeList(String em) {
    int i = 0;
    for (Employee e:employees) {
      if (e.getName().equals(em)) {
        i++;
      }
    }
    if (i > 0) {
      return true;
    } else {
      return false;
    }
  }

  private long projectTime(String p, String employee, int year, int month) {
    long projectTime = 0L;
    for (TimeSheetItem tsi:timeSheetItems) {
      if (tsi.getProject().getName().equals(p)
          && tsi.getEmployee().getName().equals(employee)
          && tsi.getBeginDate().getYear() == year
          && tsi.getBeginDate().getMonthValue() == month) {
        projectTime += tsi.hoursBetweenDates();
      }
    }
    return projectTime;
  }

  public void printToFile(String employeeName, int year, int month, Path file) {
    List<ReportLine> rl = calculateProjectByNameYearMonth(employeeName, year, month);
    List<String> lines = fileDatas(employeeName, rl, year, month);
    for (String str:lines) {
        System.out.println(str);
      }
    try (BufferedWriter writer = Files.newBufferedWriter(file)){
      for (String s : lines) {
        writer.write(s + "\n");
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

  private List<String> fileDatas(String employeeName, List<ReportLine> rl, int year, int month) {
    List<String> toWritedLines = new ArrayList<>();
    List<ReportLine> projectsTime = notNullTimeProjects(rl);
    long sumTime = sumTime(projectsTime);
    toWritedLines.add(employeeName + "\t" + year + "-" + String.format("%02d", month) + "\t" + sumTime);
    for (ReportLine pt:projectsTime) {
      toWritedLines.add(pt.getProjectName().getName() + "\t" + pt.getTime());
    }
    return toWritedLines;
  }

  private long sumTime(List<ReportLine> rl) {
    long sum = 0L;
    for (ReportLine l:rl) {
      sum += l.getTime();
    }
    return sum;
  }

  private List<ReportLine> notNullTimeProjects(List<ReportLine> rl) {
    List<ReportLine> notNullProjects = new ArrayList<>();
    for (ReportLine l:rl) {
      if (l.getTime() > 0) {
        notNullProjects.add(l);
      }
    }
    return notNullProjects;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public List<Project> getProjects() {
    return projects;
  }

}
