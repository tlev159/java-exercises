package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SeparatedSum {

  public List<Double> sum(String s) {
    String[] separated = s.split(";");
    List<Double> results = new ArrayList<>();
    double negativNumbers = 0;
    double positiveNumbers = 0;
    for (String st:separated) {
      double number = changeComaToDot(st);
      if (isNumberPositive(number)) {
        positiveNumbers += number;
      } else {
        negativNumbers += number;
      }
    }
    results.add(negativNumbers);
    results.add(positiveNumbers);
    return results;
  }

  public boolean isNumberPositive(double num) {
    return num > 0;
  }

  public double changeComaToDot(String str) {
    try {
      return Double.parseDouble(str.replace(",", "."));
    } catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Not a valid number", iae);
    }
  }
}
