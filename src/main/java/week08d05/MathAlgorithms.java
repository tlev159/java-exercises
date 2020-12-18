package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

  public int greatestCommonDivisor(int a, int b) {
    int result = 0;
    int smaller = smallerNumber(a, b);
    for (int i = smaller; i > 0; i--) {
      if (a % i == 0 && b % i == 0) {
        return i;
      }
    }
    return 1;
  }

  public int smallerNumber(int a, int b) {
    if (a < b) {
      return a;
    }
    return b;
  }
//  public int greatestCommonDivisor(int first, int second) {
//    int result = 0;
//    List<Integer> firstNumberDivs = primeDivisors(first);
//    List<Integer> secondNumberDivs = primeDivisors(second);
//
//    return result;
//  }
//
//  public List<Integer> primeDivisors(int number) {
//    List<Integer> nums = new ArrayList<>();
//    for (int i = 2; i < number / 2; i++) {
//      if (number % i == 0) {
//        nums.add(i);
//        number = number / i;
//        continue;
//      }
//    }
//    return nums;
//  }

}
