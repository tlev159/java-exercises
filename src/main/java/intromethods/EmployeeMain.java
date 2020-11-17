package intromethods;

import java.time.LocalDate;

public class EmployeeMain {

  public static void main(String[] args) {
    Employee employee = new Employee("John Doe", 2000, 260_000);

    System.out.println(employee.toString());

    employee.raiseSalary(50_000);

    System.out.println(employee.toString());

  }
}
