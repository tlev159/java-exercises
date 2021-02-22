package exam03retake01;

import java.util.Arrays;

public class CdvCheck {

  public boolean check(String taxNumber) {
    isACorrectNumber(taxNumber);
    int sum = 0;
    int div = 1;
    String[] temp = taxNumber.substring(0, 9).split("");
    int cdv = Integer.parseInt(taxNumber.substring(9));
    for (String s : temp) {
      sum += div * Integer.parseInt(s);
      div++;
    }
    if (sum % 11 == cdv) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isACorrectNumber(String str) {
    if (str.length() != 10) {
      throw new IllegalArgumentException("Wrong tax number!");
    }
    try {
      long temp = Long.parseLong(str);
      return true;
    }
    catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Not a number!", iae);
    }
  }

}
