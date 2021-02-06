package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

  public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
    if (drawCount >= maxNumber) {
      throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
    }
    Set<Integer> nums = new TreeSet<>(fillNumbers(drawCount, maxNumber));
    System.out.println("sorted numbers: " + nums);
    return nums;
  }

  private List<Integer> fillNumbers(int drawCount, int maxNumber) {
    List<Integer> numbers = new LinkedList<>();
    for (int i = 1; i <= maxNumber; i++) {
      numbers.add(i);
    }
    Collections.shuffle(numbers);

    return countNumbers(drawCount, numbers);
  }

  private List<Integer> countNumbers(int drawCount, List<Integer> shuffledNums) {
    List<Integer> nums = new LinkedList<>();
    for (int i = 0; i < drawCount; i++) {
      nums.add(shuffledNums.get(i));
    }
    System.out.println("Shuffles numbers: " + nums);
    return nums;
  }

}
