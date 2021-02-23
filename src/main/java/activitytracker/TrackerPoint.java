package activitytracker;

import java.time.LocalDate;

public class TrackerPoint {

  private long id;
  private LocalDate time;
  private double lat;
  private double lon;

  public TrackerPoint(long id, LocalDate time, double lat, double lon) {
    this.id = id;
    this.time = time;
    this.lat = lat;
    this.lon = lon;
  }

  public TrackerPoint(LocalDate time, double lat, double lon) {
    this.time = time;
    this.lat = lat;
    this.lon = lon;
  }

  public long getId() {
    return id;
  }

  public LocalDate getTime() {
    return time;
  }

  public double getLat() {
    return lat;
  }

  public double getLon() {
    return lon;
  }

  @Override
  public String toString() {
    return "TrackerPoint{" +
            "id=" + id +
            ", time=" + time +
            ", lat=" + lat +
            ", lon=" + lon +
            '}';
  }
}
