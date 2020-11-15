package debug;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

  public static void main(String[] args) {

    Employee employee1 = new Employee("John Doe", 1999);
    Employee employee2 = new Employee("Jack Doe", 1998);
    Employee employee3 = new Employee("Johny Doe", 1997);
    Employee employee4 = new Employee("Josh Doe", 1996);

    Company company = new Company(new ArrayList<>());

    company.addEmlpoyee(employee1);
    company.addEmlpoyee(employee2);
    company.addEmlpoyee(employee3);
    company.addEmlpoyee(employee4);

    String searcedEmployee = company.findEmployeeByName("Johny Doe").getName();
    int searcedEmployeeDateOfBirth = company.findEmployeeByName("Johny Doe").getYearOfBirth();

    System.out.println(searcedEmployee + ", " + searcedEmployeeDateOfBirth);

    System.out.println(company.listEmployeeNames().toString());

  }
}
