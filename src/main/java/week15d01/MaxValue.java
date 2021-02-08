package week15d01;

import java.util.*;

public class MaxValue {

  public Map.Entry<Double, Double> maxOfValues(Map<Double, Double> coordinates) {
    if (coordinates.isEmpty() || coordinates.containsValue(Double.MIN_VALUE)) {
      throw new IllegalArgumentException("Wrong parameters!");
    }
    Map.Entry<Double, Double> maxValue = null;

    for (Map.Entry<Double, Double> entry : coordinates.entrySet()) {
      if (maxValue == null || maxValue.getValue() < entry.getValue()) {
        maxValue = entry;
      }
    }
    return maxValue;
  }

}
