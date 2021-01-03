package exceptionclass.course;

public class SimpleTime {

  private static final int MIN_HOUR = 0;
  private static final int MAX_HOUR = 23;
  private static final int MIN_MINUTE = 0;
  private static final int MAX_MINUTE = 59;
  private int hour;
  private int minute;

  public SimpleTime(int hour, int minute) {
    if (hour < 0 || hour > 23) {
      throw new InvalidTimeException("Hour is invalid (0-23)", hour, MIN_HOUR, MAX_HOUR);
    }
    this.hour = hour;
    if (minute < 0 || minute > 59) {
      throw new InvalidTimeException("Minute is invalid (0-59)", minute, MIN_MINUTE, MAX_MINUTE);
    }
    this.minute = minute;
  }

  public SimpleTime(String time) {
    if (time == null) {
      throw new InvalidTimeException("Time is null");
    }
    String[] t = time.split(":");
    try {
      int h = Integer.parseInt(t[0]);
      int m = Integer.parseInt(t[1]);
    if (h < 0 || h > 23) {
      throw new InvalidTimeException("Hour is invalid (0-23)", hour, MIN_HOUR, MAX_HOUR);
    }
    this.hour = h;
    if (m < 0 || m > 59) {
      throw new InvalidTimeException("Minute is invalid (0-59)", minute, MIN_MINUTE, MAX_MINUTE);
    }
    this.minute = m;
    } catch (NumberFormatException nfe) {
      throw new InvalidTimeException("Time is not hh:mm");
    }
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d", hour, minute);
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }
}
