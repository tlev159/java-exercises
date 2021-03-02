package coronaproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Citizens {

  private long id;
  private String fullName;
  private int zip;
  private int age;
  private String email;
  private String taj;
  private long numberOfVaccination;
  private LocalDate lastVaccination;
  private List<Vaccinations> vaccinations = new ArrayList<>();


  // 1.
  public Citizens(long id, String fullName, int zip, int age, String email, String taj, long numberOfVaccination, LocalDate lastVaccination) {
    if (isCorrectCitizen(fullName, zip, age, email, email, taj)) {
      this.id = id;
      this.fullName = fullName;
      this.zip = zip;
      this.age = age;
      this.email = email;
      this.taj = taj;
      this.numberOfVaccination = numberOfVaccination;
      this.lastVaccination = lastVaccination;
    }
  }
// 2.  javítani a sorrendet!!!!!!!!!!!
  public Citizens(String fullName, int zip, int age, String email1, String taj) {
//    if (isCorrectCitizen(fullName, zip, age, email1, email2, taj)) {
      this.fullName = fullName;
      this.zip = zip;
      this.age = age;
      this.email = email1;
      this.taj = taj;
//    }
  }

  // 3.
  public Citizens(long id, String fullName, int zip, int age, String email, String taj) {
    this.id = id;
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email;
    this.taj = taj;
  }

  // 4.
  public Citizens(long id, String fullName, int zip, int age, String email, String taj, long numberOfVaccination) {
    this.id = id;
    this.fullName = fullName;
    this.zip = zip;
    this.age = age;
    this.email = email;
    this.taj = taj;
    this.numberOfVaccination = numberOfVaccination;
  }

  public void addVaccination(Vaccinations vaccinations) {
    this.vaccinations.add(vaccinations);
  }

  private boolean isCorrectCitizen(String fullName, int zip, int age, String email1, String email2, String taj) {
    CitizenValidation cv = new CitizenValidation();
    return (cv.isValidCitizenName(fullName) &&
    cv.isValidPostcode(zip) &&
    cv.isValidAge(age) &&
    cv.areTheEmailsValid(email1, email2) &&
    cv.isTajValid(taj));
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

  public LocalDate getLastVaccination() {
    return lastVaccination;
  }

  public void setNumberOfVaccination(long numberOfVaccination) {
    this.numberOfVaccination = numberOfVaccination;
  }

  public void setLastVaccination(LocalDate lastVaccination) {
    this.lastVaccination = lastVaccination;
  }

  public List<Vaccinations> getVaccinations() {
    return vaccinations;
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
