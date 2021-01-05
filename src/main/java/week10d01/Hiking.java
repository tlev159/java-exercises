package week10d01;

import java.util.ArrayList;
import java.util.List;

public class Hiking {

  public double getPlusElevation(List<Double> heightList) {
    if (heightList == null) {
      throw new IllegalArgumentException("List must be not null!");
    }
    double result = 0.0;
    double s = 0.0;
    for (int i = 0; i < heightList.size() - 1; i++) {
      s = heightList.get(i + 1) - heightList.get(i);
      if (s > 0) {
        result += s;
      }
    }
    return result;
  }
}
