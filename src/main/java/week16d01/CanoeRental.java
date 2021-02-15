package week16d01;

import java.time.LocalDateTime;

public class CanoeRental {

  private String name;
  private CanoeType caneType;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  public CanoeRental(String name, CanoeType caneType, LocalDateTime startTime) {
    this.name = name;
    this.caneType = caneType;
    this.startTime = startTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public double calculateRentalSum() {
    double result = 0.0;
    return result;
  }

  public String getName() {
    return name;
  }

  public CanoeType getCaneType() {
    return caneType;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  @Override
  public String toString() {
    return "CanoeRental{" +
            "name='" + name + '\'' +
            ", caneType=" + caneType +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            '}';
  }
}
