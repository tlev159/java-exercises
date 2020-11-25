package week05d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

  private List<User> users = new ArrayList<>();

  public List<User> getUsers() {
    return users;
  }

  public String validate(List<User> user) {
    String answer = "All valid";
    int count = 0;
    for (User eachUser: user) {
        if (eachUser.getName() != null && !eachUser.getName().isEmpty() && eachUser.getAge() > 0 && eachUser.getAge() < 120) {
          count++;
      }
    }
    if (count == user.size()) {
      return answer;
    } else
    throw new IllegalArgumentException("IllegalArgumentException");
  }
}
