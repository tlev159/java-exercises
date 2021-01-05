package week10d02;

import java.util.ArrayList;
import java.util.List;

public class MaxTravel {

  public int getMaxIndex(List<Integer> passengerList) {
    if (passengerList == null || passengerList.size() == 0) {
      throw new IllegalArgumentException("Invalid list!");
    }
//    List<Integer> result = new ArrayList<>(passengerList.size());
    int[] results = new int[30];
    for (int i = 0; i < passengerList.size(); i++) {
      results[passengerList.get(i)]++;
    }
    return getMaxOfArray(results);
  }

  public int getMaxOfArray(int[] a) {
    int max = a[0];
    int indexOfMax = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
        indexOfMax = i;
      }
    }
    return indexOfMax;
  }
}
