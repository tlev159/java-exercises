package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsersValidatorTest {

  @Test
  public void testUserValidator() {
    UserValidator uv = new UserValidator();
    List<Users> users = new ArrayList<>();
    users.add(new Users("Nagy Emőke", 45));
    users.add(new Users("Horváth Elemér", 90));
    users.add(new Users("Kis Pista", 25));
    users.add(new Users("John Doe", 99));

//    assertEquals("All valid", uv.validate(users));
  }

  @Test
  public void testUserValidatorWithWrongName() throws IllegalArgumentException {
    UserValidator uv = new UserValidator();
    List<Users> users = new ArrayList<>();
    users.add(new Users("Nagy Emőke", 45));
    users.add(new Users("", 90));
    users.add(new Users("Kis Pista", 25));
    users.add(new Users("John Doe", 99));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("Nem sikerült a művelet, mert a felhasználó neve nem lehet üres!", ex.getMessage());

  }
  @Test
  public void testUserValidatorWithNullName() throws IllegalArgumentException {
    UserValidator uv = new UserValidator();
    List<Users> users = new ArrayList<>();
    users.add(new Users("Nagy Emőke", 45));
    users.add(new Users(null, 90));
    users.add(new Users("Kis Pista", 25));
    users.add(new Users("John Doe", 99));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("Nem sikerült a művelet, mert a felhasználó neve nem lehet null!", ex.getMessage());
  }

  @Test
  public void testUserValidatorWithInvalidAge() {
    UserValidator uv = new UserValidator();
    List<Users> users = new ArrayList<>();
    users.add(new Users("Nagy Emőke", 45));
    users.add(new Users("Horváth Elemér", 190));
    users.add(new Users("Kis Pista", 25));
    users.add(new Users("John Doe", 11));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("Nem sikerült a művelet, mmert a felhasználó életkora nem lehet nagyobb, mint 120", ex.getMessage());

  }  @Test
  public void testUserValidatorWithNegativeAge() {
    UserValidator uv = new UserValidator();
    List<Users> users = new ArrayList<>();
    users.add(new Users("Nagy Emőke", 45));
    users.add(new Users("Horváth Elemér", 90));
    users.add(new Users("Kis Pista", 25));
    users.add(new Users("John Doe", -21));

    Exception ex = assertThrows(IllegalArgumentException.class, () -> uv.validate(users));
    assertEquals("Nem sikerült a művelet, mert a felhasználó életkora nem lehet negatív!", ex.getMessage());

  }
}
