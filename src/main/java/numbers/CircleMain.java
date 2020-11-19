package numbers;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class CircleMain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem az első kör sugarát:");
    int radial1 = Integer.parseInt(scanner.nextLine());
    System.out.println("Kérem a második kör sugarát:");
    int radial2 = Integer.parseInt(scanner.nextLine());
    Circle circle1 = new Circle(radial1);
    Circle circle2 = new Circle(radial2);

    System.out.println("Az első kör kerülete: " + circle1.perimeter(radial1));
    System.out.println("Az első kör területe: " + circle1.area(radial1));
    System.out.println("A második kör kerülete: " + circle1.perimeter(radial2));
    System.out.println("A második kör területe: " + circle1.area(radial2));

  }

}
