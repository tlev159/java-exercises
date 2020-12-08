package methodoverloading;

public class Time {

  private int hours;
  private int minutes;
  private int seconds;
  private Time time;


  public Time(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public Time(int hours, int minutes) {
    this.hours = hours;
    this.minutes = minutes;
  }

  public Time(int hours) {
    this.hours = hours;
  }

  public Time(Time time) {
    this.hours = time.getHours();
    this.minutes = time.getMinutes();
    this.seconds = time.getSeconds();
  }

  public boolean isEqual(Time time) {
    if (this.getHours() == time.getHours() && this.getMinutes() == time.getMinutes()
    && this.getSeconds() == time.getSeconds()) {
      return true;
    }
    return false;
  }

  public boolean isEqual(int hours, int minutes, int seconds) {
    if (this.hours == hours && this.minutes == minutes
        && this.seconds == seconds) {
    System.out.println(this.time);
      return true;
    }
    return false;
  }

  public boolean isEarlier(Time time) {
    if (this.isEarlier(time.getHours(), time.getMinutes(), time.getSeconds())) {
      return true;
    }
    return false;
  }

  public boolean isEarlier(int hours, int minutes, int seconds) {
    if (this.hours < hours || this.hours <= hours && this.minutes < minutes
          || this.hours <= hours && this.minutes <= minutes && this.seconds < seconds) {
      return true;
    }
    return false;
  }

  public int getHours() {
    return hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public Time getTime() {
    return time;
  }
}
