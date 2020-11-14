package stringtype.registration;

import java.util.SplittableRandom;

public class Uservalidator {

  private String username;
  private String password;
  private String email;

  public Uservalidator(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isValidUsername(String username) {
    if (username != "") {
      return true;
    } else {
      return false;
    }
  }

  public boolean isValidPassword(String password1, String password2) {
    if (password1 == "" || (password1.length() < 8 || !password1.equals(password2))) {
      return false;
    } else {
      return true;
    }
  }

  public boolean isValidEmail(String email) {
    if (email != ""
            && email.indexOf("@") > 0
            && email.indexOf(".") > (email.indexOf("@") + 1)
            && email.indexOf(".") < (email.length() - 1)
    ) {
      return true;
    } else {
      return false;
    }
  }

}
