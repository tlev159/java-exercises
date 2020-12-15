package defaultconstructor.date;

import java.util.Calendar;

public class SimpleDate {

  private int year;
  private int month;
  private int day;
  private int[] leapYearMonths = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int[] noLeapYearMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


  public void setDate(int year, int month, int day) {
    if (!isCorrect(year, month, day) ) {
      throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
    }
    this.year = year;
    this.month = month;
    this.day = day;
  }

  private boolean isCorrect(int year, int month, int day) {
    if (year <= 1900 || month < 1 || month > 12) {
      return false;
    }
    if (day < 1 || day > calculateMonthLength(year, month)) {
      return false;
    }
    return true;
  }

  private boolean isLeapYear(int year) {
    if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
      return true;
    } else if (year % 4 == 0 && year % 100 != 0) {
      return true;
    } else if (year % 4 == 0 && year % 100 == 0 && year % 400 != 0) {
      return false;
    }
    return false;
  }

  private int calculateMonthLength(int year, int month) {
    if (isLeapYear(year)) {
      return leapYearMonths[month - 1];
    }
    return noLeapYearMonths[month - 1];
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

}
