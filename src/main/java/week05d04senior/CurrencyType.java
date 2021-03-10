package week05d04senior;

public enum CurrencyType {

  HUF(300.0), USD(1.0/300);

  private double value;

  CurrencyType(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }
}
