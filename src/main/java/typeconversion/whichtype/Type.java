package typeconversion.whichtype;

public enum Type {

  BYTE(-128, 127), SHORT(-32_768, 32767), INT(-2_147_483_648, 2_147_483_647);

  private final long minValue;
  private final long maxValue;

  Type(long minValue, long maxValue) {
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public long getMinValue() {
    return minValue;
  }

  public long getMaxValue() {
    return maxValue;
  }
}
