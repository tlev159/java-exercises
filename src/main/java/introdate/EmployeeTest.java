package introdate;

import java.util.Scanner;

public class EmployeeTest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem az alkalmazott nevét!");
    String name = scanner.nextLine();

    System.out.println("Kérem a születési adatait!");
    System.out.println("Év:");
    int year = scanner.nextInt();
    System.out.println("Hónap:");
    int month = scanner.nextInt();
    System.out.println("Nap:");
    int day = scanner.nextInt();

    Employee employee = new Employee(year, month, day, name);

    System.out.println("A dolgozó adatai:");
    System.out.println("Neve: " + employee.getName());
    System.out.println("Születési ideje: " + employee.getDateOfBirth());
    System.out.println("Munkábaállás kezdete: " + employee.getBeginEmployment());

  }
}
