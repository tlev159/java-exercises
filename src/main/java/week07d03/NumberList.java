package week07d03;

import java.util.List;

public class NumberList {

  public boolean inIncreasing(List<Integer> integerList) {
    boolean result = false;
    for (int i = 0; i < integerList.size() - 1; i++) {
      if (integerList.get(i) > integerList.get(i + 1)) {
        return false;
      }
    }
    return true;
  }
}
