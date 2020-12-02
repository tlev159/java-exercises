package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

  public int max(List<Integer> integerList) {
    int m = 0;
    for (int i : integerList) {
      if (i > m) {
        m = i;
      }
    }
    return m;
  }
}
