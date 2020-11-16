package math;

import java.util.Random;

public class RoundingAnomaly {

  Random rnd = new Random();

  private int size;
  private double max;
  private int scale;
  private double difference;

  public double[] randomNumbers(int size, double max, int scale) {
    double[] randomNums = new double[size];
    int digitsAfterComa = (int) (Math.pow(10, scale));
    int maxNumber = (int) (max * digitsAfterComa);
    for (int i = 0; i < size; i++) {
      randomNums[i] = rnd.nextInt(maxNumber) / digitsAfterComa;
    }
    return randomNums;
  }

  public double roudAfterSum(double[] randomNums) {
    double sumBeforRound = 0.0;
    for (int i = 0; i < randomNums.length; i++) {
      sumBeforRound += randomNums[i];
    }
    return Math.round(sumBeforRound);
  }

  public double roudBeforSum(double[] randomNums) {
    double[] afterRound = new double[randomNums.length];
    for (int i = 0; i < randomNums.length; i++) {
      afterRound[i] = Math.round(randomNums[i]);
    }
    double sumAfterRound = 0.0;
    for (int i = 0; i < afterRound.length; i++) {
      sumAfterRound += afterRound[i];
    }
    return sumAfterRound;
  }

  public double difference(int size, double max, int scale) {
    double[] randomNums = new double[size];
    this.size = size;
    this.max = max;
    this.scale = scale;
    randomNums = randomNumbers(size, max, scale);
    return difference = roudAfterSum(randomNums) - roudBeforSum(randomNums);
  }



}
