package coronaproject;

public class CitizenValidation {

  protected void isCorrectCitizen(String fullName, int zip, int age, String email1, String email2, String taj) {
    isValidCitizenName(fullName);
    isValidPostcode(zip);
    isValidAge(age);
    areTheEmailsValid(email1, email2);
    isTajValid(taj);
  }

  protected void isTajValid(String taj) {
    if (!isCorrectTaj(taj)) {
      throw new IllegalArgumentException("Nem helyes a TAJ-szám!");
    }
  }

  protected void areTheEmailsValid(String email1, String email2) {
    if (!(email1.equals(email2)) || (email1.length() < 4 || !email1.contains("@"))) {
      throw new IllegalArgumentException("Email incorrect!");
    }
  }

  protected void isValidAge(int age) {
    if (age <= 10 || age >= 150) {
      throw new IllegalArgumentException("Az életkor 10 és 150 között lehet!");
//      throw new IllegalArgumentException("Wrong age!");
    }
  }

  protected void isValidPostcode(int zip) {
    if (zip == 0 || zip < 1000 || zip > 9999) {
      throw new IllegalArgumentException("Az irányítószán nem megfelelő!");
    }
  }

  protected void isValidCitizenName(String fullName) {
    if (fullName == null || fullName.isEmpty()) {
      throw new IllegalArgumentException("A név nem lehet null vagy üres!");
//      throw new IllegalArgumentException("Name can not empty!");
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

  protected void isTajExists(CoronaDao coronaDao, String taj) {
    if (coronaDao.searchForExistingTaj(taj) != null) {
      throw new IllegalArgumentException("Már van ilyen TAJ-számú regisztáció!");
    }
  }

  public boolean validationForFileRows(String fullName, int zip, int age, String email, String taj, CoronaDao coronaDao) {
    if (fullName == null || fullName.isEmpty()) {
      System.out.println("név");
      return false;
    }
    String city = coronaDao.findTownWithTheGivenZip(zip);
    if (city.isEmpty()) {
      System.out.println("város");
      return false;
    }
    if (age < 10 || age > 150) {
      System.out.println("kor");
      return false;
    }
    if (email == null || email.length() < 4 || !email.contains("@")) {
      System.out.println("email");
      return false;
    }
    if (!isCorrectTaj(taj) || coronaDao.searchForExistingTaj(taj) != null) {
      System.out.println("taj" + taj);
      return false;
    } else {
      return true;
    }
  }

}
