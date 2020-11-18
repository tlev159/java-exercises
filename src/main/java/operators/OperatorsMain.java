package operators;

public class OperatorsMain {

  public static void main(String[] args) {

    Operators operators = new Operators();

    System.out.println("Páros szám-e:");
    System.out.println(operators.isEven(134));
    System.out.println(operators.isEven(1343));

    System.out.println("Léptetések:");
    System.out.println(Integer.toBinaryString(16));
    System.out.println(Integer.toBinaryString(16 >> 2));
    System.out.println(Integer.toBinaryString(16 << 2));
    System.out.println(Integer.toBinaryString(13));
    System.out.println(Integer.toBinaryString(13 >> 2));
    System.out.println(Integer.toBinaryString(13 << 2));

    System.out.println("Kettővel szorozva:");
    System.out.println(operators.multiplyByPowerOfTwo(3, 2));
    System.out.println(operators.multiplyByPowerOfTwo(4, 2));
    System.out.println(operators.multiplyByPowerOfTwo(10, 2));

    System.out.println(0333);
  }
}
