package statements;

import java.util.Scanner;

public class TimeMain {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem az első időt (óra, perc, másodperc");
    System.out.println("Óra: ");
    int hour1 = scanner.nextInt();
    System.out.println("Perc: ");
    int minute1 = scanner.nextInt();
    System.out.println("Másodperc: ");
    int second1 = scanner.nextInt();

    System.out.println("Kérem a második időt (óra, perc, másodperc");
    System.out.println("Óra: ");
    int hour2 = scanner.nextInt();
    System.out.println("Perc: ");
    int minute2 = scanner.nextInt();
    System.out.println("Másodperc: ");
    int second2 = scanner.nextInt();

    Time time1 = new Time(hour1, minute1, second1);
    Time time2 = new Time(hour2, minute2, second2);

    System.out.println("Az első időpont: " + time1.toString() + " = " + time1.getInMinutes() + " perc");
    System.out.println("A második időpont: " + time2.toString() + " = " + time2.getInSeconds() + " másodperc");
    System.out.println("Az első korábbi, mint a második: " + time1.earlierThan(time2));

  }
}
