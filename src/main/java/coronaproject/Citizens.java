package coronaproject;

import java.time.LocalDateTime;

public class Citizens {

  private long id;
  private String fullName;
  private int zip;
  private int age;
  private String email;
  private String taj;
  private long numberOfVaccination;
  private LocalDateTime lastVaccination;

  public Citizens(long id, String fullName, int zip, int age, String email, String taj, long numberOfVaccination, LocalDateTime lastVaccination) {
    isCorrectCitizen(fullName, zip, age, email, email, taj);
    this.id = id;
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email;
    this.taj = taj;
    this.numberOfVaccination = numberOfVaccination;
    this.lastVaccination = lastVaccination;
  }

  public Citizens(String fullName, int zip, int age, String email1, String email2, String taj) {
    isCorrectCitizen(fullName, zip, age, email1, email2, taj);
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email1;
    this.taj = taj;
  }

  public Citizens(long id, String fullName, int zip, int age, String email, String taj) {
    this.id = id;
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email;
    this.taj = taj;
  }

  public Citizens(String fullName, int zip, int age, String email, String taj) {
    isCorrectCitizen(fullName, zip, age, email, email, taj);
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email;
    this.taj = taj;
  }

  private void isCorrectCitizen(String fullName, int zip, int age, String email1, String email2, String taj) {
    CitizenValidation cv = new CitizenValidation();
    cv.isValidCitizenName(fullName);
    cv.isValidPostcode(zip);
    cv.isValidAge(age);
    cv.areTheEmailsValid(email1, email2);
    cv.isTajValid(taj);
  }

  public long getId() {
    return id;
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

  public long getNumberOfVaccination() {
    return numberOfVaccination;
  }

  public LocalDateTime getLastVaccination() {
    return lastVaccination;
  }

  public void setNumberOfVaccination(long numberOfVaccination) {
    this.numberOfVaccination = numberOfVaccination;
  }

  public void setLastVaccination(LocalDateTime lastVaccination) {
    this.lastVaccination = lastVaccination;
  }

  @Override
  public String toString() {
    return "Citizens{" +
            "id=" + id +
            ", fullName='" + fullName + '\'' +
            ", zip=" + zip +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", taj='" + taj + '\'' +
            ", numberOfVaccination=" + numberOfVaccination +
            ", lastVaccination=" + lastVaccination +
            '}';
  }
}
