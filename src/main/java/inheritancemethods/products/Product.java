package inheritancemethods.products;

import java.math.BigDecimal;

public class Product {

  private String name;
  private BigDecimal unitWeight;
  private int numberOfDecimals;

  public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
    this.name = name;
    this.unitWeight = unitWeight;
    this.numberOfDecimals = numberOfDecimals;
  }

  public Product(String name, BigDecimal unitWeight) {
    this.name = name;
    this.unitWeight = unitWeight;
    this.numberOfDecimals = 2;
  }

  public BigDecimal totalWeight(int pieces) {
    return unitWeight.multiply(new BigDecimal(pieces));
  }

  public String getName() {
    return name;
  }

  public BigDecimal getUnitWeight() {
    return unitWeight;
  }

  public int getNumberOfDecimals() {
    return numberOfDecimals;
  }
}
