package week05d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

  public void validate(List<Users> users) {
    for (Users eachUsers : users) {
        if (eachUsers.getName() == null) {
          throw new IllegalArgumentException("Nem sikerült a művelet, mert a felhasználó neve nem lehet null!");
        }
        if (eachUsers.getName().isEmpty()) {
          throw new IllegalArgumentException("Nem sikerült a művelet, mert a felhasználó neve nem lehet üres!");
        }
        if (eachUsers.getAge() < 0) {
          throw new IllegalArgumentException("Nem sikerült a művelet, mert a felhasználó életkora nem lehet negatív!");
        }
        if (eachUsers.getAge() > 120) {
          throw new IllegalArgumentException("Nem sikerült a művelet, mmert a felhasználó életkora nem lehet nagyobb, mint 120");
      }
    }
  }
}
