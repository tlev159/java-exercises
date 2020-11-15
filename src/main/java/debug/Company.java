package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {

  private List<Employee> employees = new ArrayList<>();

  public Company(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmlpoyee(Employee employee) {
    employees.add(employee);
  }

  public Employee findEmployeeByName(String searchedName) {
    for (Employee employee: employees) {
      if (employee.getName().equals(searchedName)) {
        return employee;
      }
    }
    return null;
  }

  public List<String> listEmployeeNames() {
    List<String> employeeNames = new ArrayList<>();
    for (int i = 0; i < employees.size(); i++) {
      employeeNames.add(employees.get(i).getName());
    }
    return employeeNames;
  }
}
