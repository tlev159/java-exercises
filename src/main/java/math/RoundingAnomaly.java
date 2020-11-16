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
    double digitsAfterComa = Math.pow(10, scale);
    for (int i = 0; i < size; i++) {
      randomNums[i] = Math.round(rnd.nextDouble() * max * digitsAfterComa ) / digitsAfterComa;
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

  public double sumAfterRound(double[] randomNums) {
    double sumAfterRound = 0.0;
    for (int i = 0; i < randomNums.length; i++) {
      sumAfterRound += Math.round(randomNums[i]);
    }
    return sumAfterRound;
  }

  public double difference(int size, double max, int scale) {
    double[] randomNums = randomNumbers(size, max, scale);
    return Math.abs(roudAfterSum(randomNums) - sumAfterRound(randomNums));
  }

  public static void main(String[] args) {
    RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
    double[] differences = new double[100];
    for (int i = 0; i < 100; i++) {
      differences[i] = roundingAnomaly.difference(1000, 1_000_000, 5);
    }
    double sum = 0.0;
    for (int i = 0; i < 100; i++) {
      sum += differences[i];
    }
    System.out.println("A különbségek átlaga: " + sum / 100);
  }

}
