package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {

  private String name;
  private Time time;

  public Pub(String name, int hours, int minutes) {
    this.name = name;
    this.time = new Time(hours, minutes);
  }

  public Time getOpenFrom() {
    return time;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + ";" + this.time.getHours() + ":" + this.time.getMinutes();
  }
}
