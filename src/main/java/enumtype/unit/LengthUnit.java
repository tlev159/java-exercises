package enumtype.unit;

public enum LengthUnit {

  MILLIMETER(true, 1),
  CENTIMETER(true, 100),
  METER(true, 1000),
  YARD(false, 914.4),
  FOOT(false, 304.8),
  INCH(false, 25.4);

  private final boolean isSI;
  private final double valueInMM;

  LengthUnit(boolean isSI, double valueInMM) {
    this.isSI = isSI;
    this.valueInMM = valueInMM;
  }

  public boolean isSI() {
    return isSI;
  }

  public double getValueInMM() {
    return valueInMM;
  }
}
