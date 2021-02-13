package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

  private int[] doors = new int[100];

  public List<Integer> openDoors() {
    int d = 0;
    List<Integer> openedDoors = new ArrayList<>();
    while (d < 100) {
      for (int i = d; i < 100; i += d) {
        doors[i]++;
      }
      d++;
    }
    for (int i = 0; i < 100; i++) {
      if (doors[i] % 2 == 1) {
        openedDoors.add(i);
      }
    }
    return openedDoors;
  }

  public static void main(String[] args) {
    Sultan s = new Sultan();
    System.out.println(s.openDoors());
  }
}
