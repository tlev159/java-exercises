package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

  @Test
  public void testUserEmptyName() {

    Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("", "Doe", "email@email.com"));
    assertEquals("Name must be not empty!", ex.getMessage());
    Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new User("John", "", "email@email.com"));
    assertEquals("Name must be not empty!", ex1.getMessage());
  }
  @Test
  public void testtoString() {

    User user = new User("John", "Doe", "email@email.com");
    assertEquals("John Doe", user.toString());
  }

  @Test
  public void testUserEmail() {

    Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("John", "Doe", "e@m.h"));
    assertEquals("Invalid email!", ex.getMessage());
    Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new User("John", "Doe", "@m.hu"));
    assertEquals("Invalid email!", ex1.getMessage());
    Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new User("John", "Doe", "e@mhu"));
    assertEquals("Invalid email!", ex2.getMessage());
    Exception ex3 = assertThrows(IllegalArgumentException.class, () -> new User("John", "Doe", "emailhu"));
    assertEquals("Invalid email!", ex3.getMessage());
  }
}
