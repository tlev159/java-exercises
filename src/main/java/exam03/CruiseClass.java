package exam03;

public enum CruiseClass {

  LUXURY (3.0), FIRST (1.8), SECOND (1.0);

  private double value;

  CruiseClass(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }
}
