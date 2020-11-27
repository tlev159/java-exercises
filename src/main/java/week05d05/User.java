package week05d05;

public class User {

  private String firstName;
  private String lastName;
  private String email;

  public User(String firstName, String lastName, String email) {
    if (isEmpty(firstName)) {
      this.firstName = firstName;
    }
    if (isEmpty(lastName)) {
      this.lastName = lastName;
    }
    if (isValidEmail(email)) {
      this.email = email;
    }
  }

  public boolean isValidEmail(String email) {
    boolean valid = false;
    int indexOfAt = email.indexOf("@");
    int indexOfLastDot = email.lastIndexOf(".");
    if (indexOfAt < 1 || indexOfLastDot < (indexOfAt + 2) || (indexOfLastDot > email.length() - 3)) {
      throw new IllegalArgumentException("Invalid email!");
    }
    return true;
  }

  public boolean isEmpty(String str) {
    if (str == null || str.isBlank()) {
      throw new IllegalArgumentException("Name must be not empty!");
    }
    return true;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
