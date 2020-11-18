package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

  public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
    BigDecimal lUSourceInMM = new BigDecimal(source.getValueInMM());
    BigDecimal lUTargetInMM = new BigDecimal(target.getValueInMM());
    BigDecimal convertedUnit = length.multiply(lUSourceInMM).divide(lUTargetInMM, 4, RoundingMode.HALF_UP);
    return convertedUnit;
  }

  public List<LengthUnit> siUnits() {
    List<LengthUnit> units = new ArrayList<>();
    for (LengthUnit unit : LengthUnit.values()) {
      if (unit.isSI()) {
        units.add(unit);
      }
    }
    return units;
  }
}
