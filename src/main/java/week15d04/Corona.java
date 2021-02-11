package week15d04;

public class Corona implements Comparable<Corona> {

  private String yearWeek;
  private int casesWeekly;
  private String country;

  public Corona(String yearWeek, int casesWeekly, String country) {
    this.yearWeek = yearWeek;
    this.casesWeekly = casesWeekly;
    this.country = country;
  }

  public String getYearWeek() {
    return yearWeek;
  }

  public int getCasesWeekly() {
    return casesWeekly;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return "Corona{" +
            "yearWeek='" + yearWeek + '\'' +
            ", casesWeekly=" + casesWeekly +
            ", country='" + country + '\'' +
            '}';
  }

  @Override
  public int compareTo(Corona o) {
    return o.casesWeekly - this.casesWeekly;
  }
}
