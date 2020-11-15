package finalmodifier;

public class CylinderCalculator {

  CircleCalculator circleCalculator = new CircleCalculator();

  public double calculateVolumme(double r, double h) {
    return r * r * circleCalculator.PI * h;
  }

  public double calculateSurfaceArea(double r, double h) {
    return circleCalculator.calculateArea(r) + (2 * r * circleCalculator.PI * h);
  }
}
