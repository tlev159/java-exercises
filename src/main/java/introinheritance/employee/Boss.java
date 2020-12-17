package introinheritance.employee;

public class Boss extends Employee{

  private double LEADERSHIP_FACTOR = 0.1;
  private int numberOfEmployees;

  public Boss(String name, String address, double salary, int numberOfEmployees) {
    super(name, address, salary);
    this.numberOfEmployees = numberOfEmployees;
  }

  public double getSalary() {
    double bossSalary = super.getSalary() * numberOfEmployees * LEADERSHIP_FACTOR;
    return super.getSalary() + bossSalary;
  }

  public double getLEADERSHIP_FACTOR() {
    return LEADERSHIP_FACTOR;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }
}
