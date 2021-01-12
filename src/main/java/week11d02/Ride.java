package week11d02;

public class Ride {

  private int day;
  private int rideNr;
  private int rideInKm;

  public Ride(int day, int rideNr, int rideInKm) {
    this.day = day;
    this.rideNr = rideNr;
    this.rideInKm = rideInKm;
  }

  public int getDay() {
    return day;
  }

  public int getRideNr() {
    return rideNr;
  }

  public int getRideInKm() {
    return rideInKm;
  }
}
