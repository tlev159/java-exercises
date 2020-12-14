package week08d01;

import catalog.AudioFeatures;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

  @Test
  public void testR() {
    Robot rob = new Robot();
    String movement = "BHJLFE";

    assertThrows(IllegalArgumentException.class, () -> {
      rob.move(movement);
    });
  }

  @Test
  public void testMoveFromOrigo() {
    Robot rob = new Robot();
    String movement = "FFLLLLLBBBBJJJJJJJ";
    int[] goal = {3,-3};

    assertEquals(goal[0], rob.move(movement)[0]);
    assertEquals(goal[1], rob.move(movement)[1]);
  }



  @Test
  public void robotTest() {
    Robot rob = new Robot();
    String movement = "BHJLFE";
    int[] start = {0, 0};

    assertThrows(IllegalArgumentException.class, () -> {
      rob.moveFromGivenPosition(start, movement);
      });
  }

  @Test
  public void testMoveFromOrigo2() {
    Robot rob = new Robot();
    String movement = "BFBBLBJBBLFFFBFFF";
    int[] start = {0, 0};

    assertEquals("Pos.(x,y): -6,5", rob.moveFromGivenPosition(start, movement));
  }

  @Test
  public void testMoveFromNotOigo() {
    Robot rob = new Robot();
    String movement = "BFBBLBJBBLFFFBFFF";
    int[] start = {6, -5};

    assertEquals("Pos.(x,y): 0,0", rob.moveFromGivenPosition(start, movement));
  }

}
