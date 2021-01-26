package week13d02;
import java.time.LocalTime;
public class Fly {

  private String regNumber;
  private String startsEnd;
  private String City;
  private LocalTime time;

  public Fly(String regNumber, String startsEnd, String city, LocalTime time) {
    this.regNumber = regNumber;
    this.startsEnd = startsEnd;
    City = city;
    this.time = time;
  }

  public String getRegNumber() {
    return regNumber;
  }

  public String getStartsEnd() {
    return startsEnd;
  }

  public String getCity() {
    return City;
  }

  public LocalTime getTime() {
    return time;
  }

  @Override
  public String toString() {
    return "Fly{" +
        "regNumber='" + regNumber + '\'' +
        ", startsEnd='" + startsEnd + '\'' +
        ", City='" + City + '\'' +
        ", time=" + time +
        '}';
  }
}