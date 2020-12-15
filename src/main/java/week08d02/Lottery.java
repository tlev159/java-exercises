package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

  public List<Integer> getNumbers(int interval, int numbers) {
    Random rnd = new Random();
    List<Integer> lotteryNumbers = new ArrayList<>();
    int i = 0;
    while (i < numbers) {
      int number = rnd.nextInt(interval + 1);
      if (!lotteryNumbers.contains(number)) {
        lotteryNumbers.add(number);
        i++;
      }
    }
    return lotteryNumbers;
  }

  public static void main(String[] args) {
    Lottery l = new Lottery();
    System.out.println(l.getNumbers(45, 8));
  }
}
