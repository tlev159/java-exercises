package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

  @Test
  void changeFirstName() {

    NameChanger nameChanger = new NameChanger("Doe Jack");
    assertEquals("Doe Jack", nameChanger.getFullName());

    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(null));
    assertEquals("Invalid Name: null", ex.getMessage());
  }

  @Test
  public void testNameChanger() {

    NameChanger nameChanger = new NameChanger("Doe John");

    nameChanger.changeFirstName("Jane");
    assertEquals("Doe Jane", nameChanger.getFullName());
  }
}