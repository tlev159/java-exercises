package week16d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CanoeOffice {

  private List<CanoeRental> rentals = new ArrayList<>();

  public void addRental(CanoeRental rental) {
    rentals.add(rental);
  }

  public CanoeRental findRentalByName(String name) {
    for (CanoeRental cr : rentals) {
      if (cr.getName().equals(name) && cr.getEndTime() != null ) {
        return cr;
      }
    }
    throw new IllegalArgumentException("No active rental with this name (" + name + ") found!");
  }

  public void closeRentalByName(String name, LocalDateTime endTime) {
    CanoeRental canoeRental = findRentalByName(name);
    canoeRental.setEndTime(endTime);
  }

  public double getRentalPriceByName(String name, LocalDateTime endTime) {
    double result = 0.0;
    CanoeRental temp = findRentalByName(name);
    double duration = Duration.between(temp.getStartTime(), endTime).toHours();
    if (duration == Math.round(duration)) {
      result =  duration * temp.getCaneType().getValue() * 5000.0;
    } else {
      result =  Math.round(duration + 1) * temp.getCaneType().getValue() * 5000.0;

    }
    return result;
  }



  public List<CanoeRental> getRentals() {
    return rentals;
  }
}
