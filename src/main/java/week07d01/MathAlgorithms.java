package week07d01;

public class MathAlgorithms {

  public static boolean isPrime(int x) {
    if (x <1) {
      throw new IllegalArgumentException("A vizsgált szám nem lehet 1-nél kisebb!");
    }
    if (x == 1) {
      return false;
    }
    int divNum = 1;
    for (int i = 2; i <= x / 2; i++) {
      if (x % i == 0) {
        divNum++;
      }
    }
    if (divNum == 1) {
      return true;
    }
    return false;
  }
}
