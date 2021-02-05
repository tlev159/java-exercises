package collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lottery {

  private int lotteryType;
  private int ballCount;

  public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
    List<Integer> winningNumbers = new ArrayList<>();
    if (ballCount <= lotteryType) {
      throw new IllegalArgumentException("Balls must be more then the winning numbers!");
    }
    while (winningNumbers.size() < lotteryType) {
     int nextNumber = (int) (Math.random() * ballCount) +1;
     if (!winningNumbers.contains(nextNumber)) {
       winningNumbers.add(nextNumber);
     }
    }
    System.out.println(winningNumbers);
    Collections.sort(winningNumbers);
    System.out.println(winningNumbers);
    return new ArrayList<>(winningNumbers);
  }

}
