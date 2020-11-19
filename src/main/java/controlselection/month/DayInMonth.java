package controlselection.month;

import java.util.GregorianCalendar;
public class DayInMonth {


  public int numberOfDays(int year, String month) {

    String monthToLowercase = month.toLowerCase();
    switch (monthToLowercase) {
      case "január":
        return 31;
//        break;
      case "február":
        if (isLeapYear(year)) {
          return 29;
        } else {
          return 28;
//          break;
        }
      case "március":
        return 31;
//        break;
      case "április":
        return 30;
//        break;
      case "május":
        return 31;
//        break;
      case "június":
        return 30;
//        break;
      case "július":
        return 31;
//        break;
      case "augusztus":
        return 31;
//        break;
      case "szeptember":
        return 30;
//        break;
      case "október":
        return 31;
//        break;
      case "november":
        return 30;
//        break;
      case "december":
        return 31;
//        break;
      default:  throw new IllegalArgumentException("Invalid month: " + month);
    }
  }

  public static boolean isLeapYear(int year) {
    if (year % 4 != 0) {
      return false;
    } else if (year % 400 == 0) {
      return true;
    } else if (year % 100 == 0) {
      return false;
    } else {
      return true;
    }
  }
}
