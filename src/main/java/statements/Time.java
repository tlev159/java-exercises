package statements;

public class Time {

  private int hour;
  private int minute;
  private int second;

  public Time(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public int getInMinutes() {
    return hour * 60 + minute;
  }

  public int getInSeconds() {
    return hour * 3600 + minute * 60 + second;
  }

  public boolean earlierThan(Time time) {
    return this.getInSeconds() < time.getInSeconds();
  }

  @Override
  public String toString() {
    return hour + ":" + minute + ":" + second;
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public void setSecond(int second) {
    this.second = second;
  }
}
