package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

  private int distance;
  private int azimut;
  private List<NavigationPoint> navigationList = new ArrayList<>();

  public Robot() {
    this.distance = distance;
    this.azimut = azimut;
  }

  public Robot go(int meter) {
    distance += meter;
  return this;
  }

  public Robot rotate(int angle) {
    azimut+= angle;
    return this;
  }

  public Robot(List<NavigationPoint> navigationList) {
    this.navigationList = navigationList;
  }

  public Robot registerNavigationPoint() {
    this.navigationList.add(new NavigationPoint(distance, azimut));
    return this;
  }

  public int getDistance() {
    return distance;
  }

  public int getAzimut() {
    return azimut;
  }

  public List<NavigationPoint> getNavigationList() {
    return navigationList;
  }
}
