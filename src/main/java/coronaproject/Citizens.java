package coronaproject;

import java.util.Scanner;

public class Citizens {

  private String fullName;
  private int zip;
  private int age;
  private String email;
  private String taj;

  public Citizens(String fullName, int zip, int age, String email1, String email2, String taj) {
    isCorrectCitizen(fullName, zip, age, email1, email2, taj);
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email1;
    this.taj = taj;
  }

  private void isCorrectCitizen(String fullName, int zip, int age, String email1, String email2, String taj) {
    if (fullName == null || fullName.isEmpty()) {
      throw new IllegalArgumentException("Name can not empty!");
    }
    if (zip == 0 || zip < 1000 || zip > 9999) {
      throw new IllegalArgumentException("Post code can not be null and must be 4 digits!");
    }
    if (age <= 10 || age >= 150) {
      throw new IllegalArgumentException("Wrong age!");
    }
    if (!(email1.equals(email2)) || (email1.length() < 4 || !email1.contains("@"))) {
      throw new IllegalArgumentException("Email incorrect!");
    }
    if (!isCorrectTaj(taj)) {
      throw new IllegalArgumentException("Invalid TAJ!");
    }
  }

  private boolean isCorrectTaj(String taj) {
    if (taj.length() != 9) {
      return false;
    }
    int cvd = Integer.parseInt(taj) % 10;
    int sum = 0;
    String[] tempTaj = taj.substring(0,9).split("");
    for (int i = 0; i < 8; i+= 2) {
//      System.out.print(i + ": ");
      sum += Integer.parseInt(tempTaj[i]) * 3;
//      System.out.print(sum + ", ");
      sum += Integer.parseInt(tempTaj[i + 1]) * 7;
//      System.out.println(sum);
    }
//    System.out.println(sum);
    return (sum % 10 == cvd) ? true:false;
  }

  public String getFullName() {
    return fullName;
  }

  public int getZip() {
    return zip;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  public String getTaj() {
    return taj;
  }

  @Override
  public String toString() {
    return "Citizens{" +
            "fullName='" + fullName + '\'' +
            ", zip=" + zip +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", taj='" + taj + '\'' +
            '}';
  }
}
