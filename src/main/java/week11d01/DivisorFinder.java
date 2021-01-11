package week11d01;

public class DivisorFinder {

  public int findDivisors(int n) {
    if (n == 0) {
      throw new IllegalArgumentException("Invalid number!");
    }
    String numberForLength = Integer.toString(n);
    int number = n;
    int result = 0;
    for (int i = 0; i < numberForLength.length(); i++) {
      if (n % (number % 10) == 0) {
        result++;
      }
      number /= 10;
    }
    return result;
  }
}
