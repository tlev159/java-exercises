package enumtype.unit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class UnitConverterMain {

  public static void main(String[] args) {

    UnitConverter unitConverter = new UnitConverter();

    System.out.println(unitConverter.convert(new BigDecimal(10), LengthUnit.MILLIMETER, LengthUnit.INCH));
    System.out.println(unitConverter.convert(new BigDecimal(10), LengthUnit.INCH, LengthUnit.INCH));
    System.out.println(unitConverter.convert(new BigDecimal(10), LengthUnit.METER, LengthUnit.FOOT));
    System.out.println(unitConverter.convert(new BigDecimal(10), LengthUnit.YARD, LengthUnit.CENTIMETER));

    System.out.println("Mértékegységek: " + Arrays.toString(LengthUnit.values()));
    System.out.println("Ebből SI mértékegységek: " + unitConverter.siUnits());

  }
}
