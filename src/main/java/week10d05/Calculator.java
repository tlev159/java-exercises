package week10d05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Calculator {

  public int findMinSum(int[] arr) {
    if (arr.length < 4) {
      throw new IllegalArgumentException("Not valid array");
    }
    int sum = 0;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      sum+= arr[i];
    }
    return sum;
  }
}
