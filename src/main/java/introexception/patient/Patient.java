package introexception.patient;

public class Patient {

  private String name;
  private String socialSecurityNumber;
  private int yearOfBirth;

  public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
    SsnValidator ssnv = new SsnValidator();
    try {
      int validInt = Integer.parseInt(socialSecurityNumber);
      ssnv.isValidSsn(socialSecurityNumber);
    } catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Nem érvényes a TAJ-szám");
    }
      if (name == null || name.isEmpty() || yearOfBirth < 1900) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.yearOfBirth = yearOfBirth;
  }

  public String getName() {
    return name;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }
}
