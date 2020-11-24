package introexception.patient;

public class SsnValidator {

  public boolean isValidSsn(String ssn) {
    if (ssn.length() != 9) {
      return false;
    } else {
      String[] modifiedS = ssn.split("");
      Integer n = Integer.parseInt(ssn);
      int sum = 0;
      for (int i = 0; i < ssn.length() - 1; i++) {
        if (i % 2 == 1) {
          sum += (Integer.parseInt(modifiedS[i]) * 7);
        } else {
          sum += (Integer.parseInt(modifiedS[i]) * 3);
        }
      }
      if (sum % 10 == Integer.parseInt(modifiedS[8])) {
        return true;
      } else {
        return false;
      }
    }
  }
}
