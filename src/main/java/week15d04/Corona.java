package week15d04;

public class Corona {

  private String dateRep;
  private String yearWeek;
  private int casesWeekly;
  private int deathsWeekly;
  private String country;

  public Corona(String dateRep, String yearWeek, int casesWeekly, int deathsWeekly, String country) {
    this.dateRep = dateRep;
    this.yearWeek = yearWeek;
    this.casesWeekly = casesWeekly;
    this.deathsWeekly = deathsWeekly;
    this.country = country;
  }

  public String getDateRep() {
    return dateRep;
  }

  public String getYearWeek() {
    return yearWeek;
  }

  public int getCasesWeekly() {
    return casesWeekly;
  }

  public int getDeathsWeekly() {
    return deathsWeekly;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return country + ": " +
            "dateRep='" + dateRep + ", yearWeek='" + yearWeek + ", casesWeekly=" + casesWeekly +
            ", deathsWeekly=" + deathsWeekly;
  }
}
