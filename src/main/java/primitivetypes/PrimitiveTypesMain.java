package primitivetypes;

import javax.lang.model.type.PrimitiveType;

public class PrimitiveTypesMain {

  public static void main(String[] args) {

//    System.out.println(Boolean.parseBoolean("etrue")); //tartalmazza a "true"-t, de mégis false!
//    System.out.println(Boolean.parseBoolean("true"));

    PrimitiveTypes primitiveTypes = new PrimitiveTypes();

    System.out.println("13: " + primitiveTypes.toBinaryString(13));
    System.out.println();
    System.out.println("13: " + Integer.toBinaryString(13));
    System.out.println();

    System.out.println("0: " + primitiveTypes.toBinaryString(0));
    System.out.println();
    System.out.println("0: " + Integer.toBinaryString(0));
    System.out.println();

    System.out.println("-15: " + primitiveTypes.toBinaryString(-15));
    System.out.println();
    System.out.println("-15: " + Integer.toBinaryString(-15));
    System.out.println();

    int i = 0b11111111111111111111111111111100;
    System.out.println(i);

    System.out.println(new Integer(1) + new Integer(2));

  }

}
