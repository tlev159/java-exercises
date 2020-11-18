package enumtype.week;

public class WorkDayCalculatorMain {

  public static void main(String[] args) {
    WorkdayCalculator wdk = new WorkdayCalculator();

    System.out.println(wdk.dayTypes(Day.FRIDAY, 5));
  }
}
