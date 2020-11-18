package operators;

public class Operators {

  public boolean isEven(int n) {
    if (n % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int multiplyByPowerOfTwo(int a, int b) {
    return a << b;
  }


}
