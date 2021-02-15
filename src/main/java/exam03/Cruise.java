package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

  private Boat boat;
  private LocalDate sailing;
  private double basicPrice;
  private List<Passenger> passengers = new ArrayList<>();

  public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
    this.boat = boat;
    this.sailing = sailing;
    this.basicPrice = basicPrice;
  }

  public void bookPassenger(Passenger passenger) {
    if (passengers.size() < boat.getMaxPassengers()) {
      passengers.add(passenger);
    } else {
      throw new IllegalArgumentException("No more place for another passenger!");
    }
  }

  public double getPriceForPassenger(Passenger passenger) {
    return basicPrice * passenger.getCruiseClass().getValue();
  }

  public Passenger findPassengerByName(String name) {
    for (Passenger passenger : passengers) {
      if (passenger.getName().equals(name)) {
        return passenger;
      }
    }
    throw new IllegalArgumentException("No passenger (" + name + ") found!");
  }

  public List<String> getPassengerNamesOrdered() {
    List<String> orderedNames = new ArrayList<>();
    for (Passenger passenger : passengers) {
      orderedNames.add(passenger.getName());
    }
    Collections.sort(orderedNames);
    return orderedNames;
  }

  public double sumAllBookingsCharged() {
    double sumOfBookings = 0.0;
    for (Passenger passenger : passengers) {
      sumOfBookings += getPriceForPassenger(passenger);
    }
    return sumOfBookings;
  }

  public Map<CruiseClass, Integer> countPassengerByClass() {
    Map<CruiseClass, Integer> passengersByClass = new HashMap<>();
    for (Passenger passenger : passengers) {
      if (!passengersByClass.containsKey(passenger.getCruiseClass())) {
        passengersByClass.put(passenger.getCruiseClass(), 1);
      } else {
        passengersByClass.put(passenger.getCruiseClass(), passengersByClass.get(passenger.getCruiseClass()) + 1);
      }
    }
    return passengersByClass;
  }

  public Boat getBoat() {
    return boat;
  }

  public LocalDate getSailing() {
    return sailing;
  }

  public double getBasicPrice() {
    return basicPrice;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }
}
