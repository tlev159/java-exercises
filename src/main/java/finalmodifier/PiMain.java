package finalmodifier;

public class PiMain {

  public static void main(String[] args) {

    CylinderCalculator cylinderCalculator = new CylinderCalculator();

    CircleCalculator circleCalculator = new CircleCalculator();

    System.out.println(cylinderCalculator.calculateVolumme(3, 5));
    System.out.println(cylinderCalculator.calculateSurfaceArea(3, 5));

    System.out.println(circleCalculator.calculatePerimeter(4));
    System.out.println(circleCalculator.calculateArea(4));

    System.out.println("A PI értéke: " + circleCalculator.PI);

    System.out.println(circleCalculator.calculatePerimeter(10));
  }
}
