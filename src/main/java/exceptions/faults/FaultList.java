package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

  private int errorCounter;

  public List<String> processLines(List<String> lines) {
    if (lines == null) {
      throw new IllegalArgumentException("Lines must be not null");
    }
    List<String> result = new ArrayList<>();
    for (int i = 0; i < lines.size(); i++) {
      String[] s = lines.get(i).split(",");
      if (isLineCorrect(s) != 0) {
        result.add(s[0] + "," + isLineCorrect(s));
      }
    }
    return result;
  }

  private int isLineCorrect(String[] str) {
    errorCounter = 0;
    if (isStringCorrect(str)) {
      errorCounter += isValueCorrect(str[1]);
      errorCounter += isDateCorrect(str[2]);
      switch (errorCounter) {
        case 2:
          return ProcessingResult.VALUE_ERROR.getCode();
        case 3:
          return ProcessingResult.DATE_ERROR.getCode();
        case 5:
          return ProcessingResult.VALUE_AND_DATE_ERROR.getCode();
        default:
          return 0;
      }
    } else {
      return ProcessingResult.WORD_COUNT_ERROR.getCode();
    }

  }

  private boolean isStringCorrect(String[] str) {
    if (str.length == 3) {
      return true;
    }
    return false;
  }

  private int isValueCorrect(String str) {
    try {
      Double.parseDouble(str);
      return 0;
    } catch (IllegalArgumentException iae) {
      return 2;
    }
  }

  private int isDateCorrect(String str) {
    try {
      DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.");
      dateFormat.parse(str);
      return 0;
    } catch (ParseException pe) {
      return 3;
    }
  }

}
