package exceptionclass.course;

public class InvalidTimeException extends RuntimeException {

  private int min;
  private int max;
  private int hour;
  private int minute;

  public InvalidTimeException(String message, int data, int min, int max) {
    super(message);
    this.hour = data;
    this.min = min;
    this.max = max;
  }

  public InvalidTimeException(String message) {
    super(message);
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }
}
