package week05d04senior;

public enum Currency {

  HUF(300.0, "HUF"), USD(0.00333, "USD");

  private double changingRate;
  private String currencyName;

  Currency(double changingRate, String currencyName) {
    this.changingRate = changingRate;
    this.currencyName = currencyName;
  }

  public double getChangingRate() {
    return changingRate;
  }

  public String getCurrencyName() {
    return currencyName;
  }
}
