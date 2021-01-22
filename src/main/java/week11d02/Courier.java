package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

  private List<Ride> rides = new ArrayList<>();

  public List<Ride> getRides() {
    return rides;
  }

  public void addRide(Ride newRide) {
    if (rides.size() == 0 && isCorrectFirstRideDay(newRide)) {
      rides.add(newRide);
    } else if (!isCorrectNewRide(newRide)) {
      throw new IllegalArgumentException("Invalid new ride!");
    } else {
      rides.add(newRide);
    }
  }

  public boolean isCorrectFirstRideDay(Ride firstRide) {
    boolean isCorrectDay = (firstRide.getDay() > 0 && firstRide.getDay() <= 7);
    boolean isCorrectRideNr = (firstRide.getRideNr() == 1);
    if (firstRide == null || !isCorrectDay || !isCorrectRideNr) {
      throw new IllegalArgumentException("Invalid ride!");
    }
    return true;
  }

  public boolean isCorrectNewRide(Ride newRide) {
    boolean result = false;
    boolean isCorrectDayInterval = (newRide.getDay() > 0 && newRide.getDay() <= 7);
    boolean isFirstNrFromDay = (newRide.getRideNr() == 1);
    boolean isValidRideNr = (newRide.getRideNr() > 0 && newRide.getRideNr() == rides.get(rides.size() - 1).getRideNr() + 1);
    boolean isAnotherDay = (rides.get(rides.size() - 1).getDay() < newRide.getDay());
    boolean isValidRideNrBySameDay = (rides.get(rides.size() - 1).getDay() == newRide.getDay());
    if (isCorrectDayInterval && (isAnotherDay && isFirstNrFromDay) //another day
        || isCorrectDayInterval && isValidRideNrBySameDay && isValidRideNr) { //same day
      result = true;
    }
    return result;
  }

  public int firstFreeDay() {
    boolean[] firstFreeDay = new boolean[7];
    for (int i = 0; i < 7; i++) {
      for (Ride r:rides) {
        if (r.getDay() == i + 1) {
          firstFreeDay[i] = true;
          break;
        } else {
          firstFreeDay[i] = false;
        }
      }
    }
    for (int j = 0; j < 7; j++) {
      if (!firstFreeDay[j]) {
        return j + 1;
      }
    }
    return -1;
  }
}
