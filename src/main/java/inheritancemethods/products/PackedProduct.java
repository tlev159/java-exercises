package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product{

  private int packingUnit;
  private BigDecimal weightOfBox;

  public PackedProduct(String name, BigDecimal uniWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
    super(name, uniWeight, numberOfDecimals);
    this.packingUnit = packingUnit;
    this.weightOfBox = weightOfBox;
  }

  @Override
  public BigDecimal totalWeight(int pieces) {
    BigDecimal boxesWeight;
    if (pieces % packingUnit != 0) {
      boxesWeight = BigDecimal.valueOf((long) pieces / packingUnit).add(new BigDecimal(1.0));
      System.out.println("nem:" + boxesWeight);
    } else {
      boxesWeight = BigDecimal.valueOf(pieces / packingUnit);
      System.out.println("egészoszós: " + boxesWeight);
    }
    return super.totalWeight(pieces).add(boxesWeight.multiply(weightOfBox));
  }

  public int getPackingUnit() {
    return packingUnit;
  }

  public BigDecimal getWeightOfBox() {
    return weightOfBox;
  }
}
