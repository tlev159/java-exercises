package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

  @Test
  public void testUserValidator() {
    UserValidator uv = new UserValidator();
    List<User> users = new ArrayList<>();
    users.add(new User("Nagy Emőke", 45));
    users.add(new User("Horváth Elemér", 90));
    users.add(new User("Kis Pista", 25));
    users.add(new User("John Doe", 99));

    assertEquals("All valid", uv.validate(users));
  }

  @Test
  public void testUserValidatorWithWrongName() throws IllegalArgumentException {
    UserValidator uv = new UserValidator();
    List<User> users = new ArrayList<>();
    users.add(new User("Nagy Emőke", 45));
    users.add(new User("", 90));
    users.add(new User("Kis Pista", 25));
    users.add(new User("John Doe", 99));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("IllegalArgumentException", ex.getMessage());

  }

  @Test
  public void testUserValidatorWithInvalidAge() {
    UserValidator uv = new UserValidator();
    List<User> users = new ArrayList<>();
    users.add(new User("Nagy Emőke", 45));
    users.add(new User("Horváth Elemér", 90));
    users.add(new User("Kis Pista", 25));
    users.add(new User("John Doe", 121));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("IllegalArgumentException", ex.getMessage());

  }
}
