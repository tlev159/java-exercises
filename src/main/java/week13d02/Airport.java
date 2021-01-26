package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {
  private List<Fly> flies = new ArrayList<>();

  public List<Fly> getFlies() {
    return new ArrayList<>(flies);
  }

  public void readFiles() {
    InputStreamReader is = new InputStreamReader(Airport.class.getResourceAsStream("cities.txt"));
    try (BufferedReader reader = new BufferedReader(is)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] splitLine = line.split(" ");
        flies.add(new Fly(splitLine[0], splitLine[1], splitLine[2], makeLocalTimeFromString(splitLine[3])));
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }
  }

  private LocalTime makeLocalTimeFromString(String s) {
    String[] time = s.split(":");
    return LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

  }

  public String witchIsMore() {
    int arrivals = 0;
    int departures = 0;
    for (Fly fly : flies) {
      if (fly.getStartsEnd().equals("Arrival")) {
        arrivals++;
      } else {
        departures++;
      }
    }
    return arrivals > departures ? "Arrival" : "Departure";
  }

  public Fly searchFlyAtRegNumber(String regNumber) {
    for (Fly fly : flies) {
      if (fly.getRegNumber().equals(regNumber)) {
        return fly;
      }
    }
    throw new IllegalStateException("Fly not found.");
  }

  public List<Fly> searchFliesFromToCity(String city, String startEnd) {
    List<Fly> result = new ArrayList<>();
    for (Fly fly : flies) {
      if (fly.getCity().equals(city) && fly.getStartsEnd().equals(startEnd)) {
        result.add(fly);
      }
    }
    return result;
  }

  public Fly searchEarliestFly() {
    Fly earliestFly = firstDeparture();

    for (Fly fly : flies) {
      if (fly.getStartsEnd().equals("Departure") && fly.getTime().isBefore(earliestFly.getTime())) {
        earliestFly = fly;
      }
    }
    return earliestFly;
  }

  private Fly firstDeparture() {
    for (Fly fly : flies) {
      if (fly.getStartsEnd().equals("Departure")) {
        return fly;
      }
    }
    throw new IllegalStateException("No Departure");
  }
}