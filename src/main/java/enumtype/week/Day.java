package enumtype.week;

import static enumtype.week.DayType.HOLIDAY;
import static enumtype.week.DayType.WORKDAY;

public enum Day {

  MONDAY(DayType.WORKDAY),
  TUESDAY(DayType.WORKDAY),
  WEDNESDAY(DayType.WORKDAY),
  THURSDAY(DayType.WORKDAY),
  FRIDAY(DayType.WORKDAY),
  SATURDAY(DayType.HOLIDAY),
  SUNDAY(DayType.HOLIDAY);

  private final DayType dayType;

  Day(DayType dayType) {
    this.dayType = dayType;
  }

  public DayType getDayType() {
    return dayType;
  }
}
