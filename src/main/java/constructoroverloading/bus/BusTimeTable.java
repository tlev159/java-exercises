package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

  private List<SimpleTime> timeTable;

  public BusTimeTable(List<SimpleTime> timeTable) {
    this.timeTable = timeTable;
  }

  public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
    List<SimpleTime> timeOfBusses = new ArrayList<>();
    for (int i = firstHour; i <= lastHour; i++) {
      timeOfBusses.add(new SimpleTime(i, everyMinute));
    }
    timeTable = timeOfBusses;
  }

  public SimpleTime nextBus(SimpleTime actual) {
    for (SimpleTime st:timeTable) {
      if (st.difference(actual) >= 0) {
        return st;
      }
    }
    throw new IllegalStateException("No more buses today!");
  }

  public List<SimpleTime> getTimeTable() {
    return timeTable;
  }
}
