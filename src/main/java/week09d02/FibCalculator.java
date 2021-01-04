package week09d02;

public class FibCalculator {

  public static int[] FIB_NUMBERS = new int[1000];
  public static void main(String[] args) {
    System.out.println(sumEvens(10));
  }

  static long sumEvens(int bound) {
    int sum = 0;
    int counter = 0;
    while (fib(counter) < bound) {
      if (FIB_NUMBERS[counter] % 2 == 0) {
        sum += FIB_NUMBERS[counter];
      }
      counter++;
    }
    return sum;
  }

  static int fib(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
        return 1;
    } else {
      if (FIB_NUMBERS[n] == 0) {
        FIB_NUMBERS[n] = fib(n - 1) + fib(n - 2);
      }
      return FIB_NUMBERS[n];
    }
  }
}
