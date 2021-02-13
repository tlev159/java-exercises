package week04d01;

public class NameChanger {

  private String fullName;

  public NameChanger(String fullName) {
    if (fullName == null || fullName.isBlank()) {
      throw new IllegalArgumentException("Invalid Name: " + fullName);
    }
    this.fullName = fullName;
  }

  public void changeFirstName(String firstName) {
    String[] temp = fullName.split(" ");
    this.fullName = new StringBuilder(temp[0] + " " + firstName).toString();
  }

  public String getFullName() {
    return fullName;
  }
}
