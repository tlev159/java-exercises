package arrays;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class ArraysMain {

  public String numberOfDaysAsString() {
    int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return Arrays.toString(numberOfDays);
  }

  public List<String> daysOfWeek() {
    return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
  }

  public String multiplicationTableAsString(int size) {
    int[][] multiplation = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        multiplation[i][j] = (i + 1) * (j + 1);
      }
    }
    return Arrays.deepToString(multiplation);
  }

  public boolean sameTempValues(double[] day, double[] anotherDay) {
    return Arrays.equals(day, anotherDay);
  }

  public boolean wonLottery(int[] a, int[] b) {
    int[] aa = Arrays.copyOf(a, a.length);
    int[] bb = Arrays.copyOf(b, b.length);
    Arrays.sort(aa);
    Arrays.sort(bb);
    return Arrays.equals(aa, bb);
  }

  public static void main(String[] args) {
    ArraysMain arraysMain = new ArraysMain();

    System.out.println(arraysMain.numberOfDaysAsString());

    System.out.println(arraysMain.daysOfWeek());

    System.out.println(arraysMain.multiplicationTableAsString(4));

    double[] day = {1.0, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.1, 11.1, 12.2, 13.3, 14.4, 15.5, 16.6, 17.7, 18.8, 19.9, 20.0, 21.1, 22.2, 23.3, 24.4};
    double[] anotherDay = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.1, 11.1, 12.2, 13.3, 14.4, 15.5, 16.6, 17.7, 18.8, 19.9, 20.0, 21.1, 22.2, 23.3, 24.4};
    System.out.println(arraysMain.sameTempValues(day, anotherDay));

    int[] a = {31, 10, 11, 20, 76, 13, 310, 20};
    int[] b = {310, 31, 11, 20, 76, 13, 10, 20};
    System.out.println(arraysMain.wonLottery(a, b));

    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));


  }

}
