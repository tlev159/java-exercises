package numbers;

public class Circle {

  private int diameter;
  private static final double PI = 3.14;

  public Circle(int diameter) {
    this.diameter = diameter;
  }

  public double perimeter(double r) {
    return 2 * r * PI;
  }

  public double area(double r) {
    return r * r * PI;
  }

  public int getDiameter() {
    return diameter;
  }
}
