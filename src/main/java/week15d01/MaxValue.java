package week15d01;

import java.util.*;

public class MaxValue {

  public double MaxOfValues(Map<Double, Double> coordinates) {
    Set<Double> values = new TreeSet<>(coordinates.values());
    double maxValue = Collections.max(values);
    double keyOfMaxValue = getKey(coordinates, maxValue);
    return keyOfMaxValue;
  }

  public double MinOfValues(Map<Double, Double> coordinates) {
    Set<Double> values = new TreeSet<>(coordinates.values());
    double minValue = Collections.min(values);
    double keyOfMinValue = getKey(coordinates, minValue);
    return keyOfMinValue;
  }

  private double getKey(Map<Double, Double> map, double value) {
    for (Map.Entry<Double, Double> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    throw new IllegalArgumentException("No key with this value!");
  }
}
