package introcontrol;

public class IntroControlMain {

  public static void main(String[] args) {
    IntroControl introControl = new IntroControl();

    System.out.println(introControl.substractTenIfGreaterThanTen(9));
    System.out.println(introControl.substractTenIfGreaterThanTen(13));

    System.out.println(introControl.describeNumber(0));
    System.out.println(introControl.describeNumber(3));

    System.out.println(introControl.greetingToJoe("Jack"));
    System.out.println(introControl.greetingToJoe("Joe"));

    System.out.println(introControl.calculateBonus(999_999));
    System.out.println(introControl.calculateBonus(1_100_000));

    System.out.println(introControl.calculateConsumption(9950, 130));
    System.out.println(introControl.calculateConsumption(9850, 9999));

    introControl.printNumbers(13);
    System.out.println();
    introControl.printNumbersBetween(11, 20);
    System.out.println();
    introControl.printNumbersBetweenAnyDirection(13, 20);
    System.out.println();
    introControl.printNumbersBetweenAnyDirection(20, 13);

    System.out.println();
    introControl.printOddNumbers(10);
    System.out.println();
    introControl.printOddNumbers(13);

  }
}
