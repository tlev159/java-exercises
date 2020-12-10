package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LabTest {

  @Test
  public void testLab() {

    Lab lab = new Lab("Task 1");

    assertEquals("Task 1", lab.getTitle());
    assertFalse(lab.isCompleted());
  }

  @Test
  public void testLab2() {

    Lab lab = new Lab("Task 2");
    lab.complete();

    assertEquals("Task 2", lab.getTitle());
    assertTrue(lab.isCompleted());
  }

  @Test
  public void testLab3() {

    Lab lab = new Lab("Task 3");
    lab.complete();

    assertEquals("Task 3", lab.getTitle());
    assertTrue(lab.isCompleted());
    assertEquals(LocalDate.now(), lab.getCompletedAt());
  }

}
