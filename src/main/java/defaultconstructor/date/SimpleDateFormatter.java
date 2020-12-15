package defaultconstructor.date;

import java.time.LocalDate;

public class SimpleDateFormatter {

  private CountryCode defaultCountry;

  public SimpleDateFormatter() {
    this.defaultCountry = CountryCode.HU;
  }

  public String formatDateString(SimpleDate simpleDate) {
    return formatDateStringByCountryCode(defaultCountry, simpleDate);
  }

  public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
    if (countryCode == CountryCode.HU) {
      return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
    } else if (countryCode == CountryCode.EN) {
      return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
    } else {
      return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
    }
  }

}
