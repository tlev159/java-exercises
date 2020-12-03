package week06d03;

import java.util.ArrayList;
import java.util.List;

public class Series {

  List<Integer> integers = new ArrayList<>();

  public Series(List<Integer> integers) {
    if (integers.size() < 2) {
      throw new IllegalArgumentException("The integer list must contains min of two elements!");
    }
    this.integers = integers;
  }

  public String calculateSeriesType() {
    String type = "Össze-vissza";
    if (isGroving()) {
      type = "Növekvő";
    } else if (isRegressive()) {
      type = "Csökkenő";
    }
    return type;
  }

  public boolean isGroving() {
    boolean is = true;
    for (int i = 0; i < integers.size() -1; i++) {
      if (integers.get(i) > integers.get(i + 1)) {
        is = false;
      }
    }
    return is;
  }

  public boolean isRegressive() {
    boolean is = true;
    for (int i = 0; i < integers.size() -1; i++) {
      if (integers.get(i) < integers.get(i + 1)) {
        is = false;
      }
    }
    return is;
  }
}
