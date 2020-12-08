package week07d02;

import java.util.Scanner;

public class DigitSum {

  public int sumOfDigits(int x) {
    int result = 0;
    String[] a = String.valueOf(x).split("");
    for (String n:a) {
      result+= Integer.parseInt(n);
    }
    return result;
  }
}
