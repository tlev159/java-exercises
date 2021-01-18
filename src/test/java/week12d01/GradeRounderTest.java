package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

  @Test
  void roundGrades() {
    int[] arr = new int[90];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    GradeRounder gr = new GradeRounder();
    int[] arr2 = gr.roundGrades(arr);

    assertEquals(39, arr2[39]);
    assertEquals(40, arr2[40]);
    assertEquals(60, arr2[58]);
    assertEquals(60, arr2[59]);
    assertEquals(60, arr2[60]);
    assertEquals(71, arr2[71]);
    assertEquals(82, arr2[82]);
  }
  @Test
  void roundGradesWithRandomArray() {
    Random rnd = new Random(500);
    int[] arr = new int[rnd.nextInt(100)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    GradeRounder gr = new GradeRounder();
    int[] arr2 = gr.roundGrades(arr);

    for (int i = 0; i < arr.length; i++) {
    }

    assertEquals(39, arr2[39]);
    assertEquals(40, arr2[40]);
    assertEquals(60, arr2[58]);
    assertEquals(60, arr2[59]);
    assertEquals(91, arr2[91]);
    assertEquals(95, arr2[93]);
    assertEquals(95, arr2[94]);
  }

}