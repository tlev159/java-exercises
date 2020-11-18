package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

  public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
    List<DayType> dayTypes = new ArrayList<>();
    Day d = firstDay;
    for (int i = 0; i < numberOfDays; i++) {
      dayTypes.add(d.getDayType());
      d = nextDay(d);
    }
    return dayTypes;
  }

  private Day nextDay(Day day) {
    int indexOfToday = day.ordinal();
    int indexOfNextDay = 0;
    if (day.ordinal() == 6) {
      indexOfNextDay = 0;
    } else {
      return Day.values()[indexOfToday + 1];
    }
    return Day.values()[indexOfNextDay];
  }
}
