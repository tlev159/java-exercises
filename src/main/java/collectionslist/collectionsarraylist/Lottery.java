package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

  public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
    if (ballCount <= lotteryType) {
      throw new IllegalArgumentException("Balls must be more then the winning numbers!");
    }
    List<Integer> winningNumbers = fillNumbers(ballCount).subList(0, lotteryType);
    Collections.sort(winningNumbers);
    return new ArrayList<>(winningNumbers);
  }

  private List<Integer> fillNumbers(int ballCount) {
    List<Integer> balls = new ArrayList<>();
    for (int i = 1; i < ballCount; i++) {
      balls.add(i);
    }
    Collections.shuffle(balls);
    return balls;
  }

}
