package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private List<TrackPoint> trackPoints = new ArrayList<>();

  public void addTrackPoint(TrackPoint trackPoint) {
    this.trackPoints.add(trackPoint);
  }

  public double getFullElevation() {
    double fullElevation = 0.0;
    for (int i = 0; i < trackPoints.size() - 1; i++) {
      double isElevation = trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
      if (isElevation > 0) {
        fullElevation += isElevation;
      }
    }
    return fullElevation;
  }

  public double getFullDecrease() {
    double fullDecrease = 0.0;
    for (int i = 0; i < trackPoints.size() - 1; i++) {
      double isDecrease = trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation();
      if (isDecrease > 0) {
        fullDecrease += isDecrease;
      }
    }
    return fullDecrease;
  }

  public Coordinate findMinimumCoordinate() {
    double minimumLatitude = trackPoints.get(0).getCoordinate().getLatitude();
    double minimumLongitude = trackPoints.get(0).getCoordinate().getLongitude();
    for (TrackPoint tp : trackPoints) {
      if (tp.getCoordinate().getLatitude() < minimumLatitude) {
        minimumLatitude = tp.getCoordinate().getLatitude();
      }
      if (tp.getCoordinate().getLongitude() < minimumLongitude) {
        minimumLongitude = tp.getCoordinate().getLongitude();
      }
    }
    return new Coordinate(minimumLatitude, minimumLongitude);
  }

  public Coordinate findMaximumCoordinate() {
    double maximumLatitude = trackPoints.get(0).getCoordinate().getLatitude();
    double maximumLongitude = trackPoints.get(0).getCoordinate().getLongitude();
    for (TrackPoint tp : trackPoints) {
      if (tp.getCoordinate().getLatitude() > maximumLatitude) {
        maximumLatitude = tp.getCoordinate().getLatitude();
      }
      if (tp.getCoordinate().getLongitude() > maximumLongitude) {
        maximumLongitude = tp.getCoordinate().getLongitude();
      }
    }
    return new Coordinate(maximumLatitude, maximumLongitude);
  }

  public double getDistance() {
    double distance = 0.0;
    for (int i = 0; i < trackPoints.size() - 1; i++) {
      distance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
    }
    return distance;
  }

  public double getRectangleArea() {
    double a = (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude());
    double b = (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
    return a * b;
  }

  public List<TrackPoint> getTrackPoints() {
    return trackPoints;
  }
}
