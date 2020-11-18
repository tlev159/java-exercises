package primitivetypes;

public class PrimitiveTypes {

  private static final int STRING_LENGTH = 32;

  public String toBinaryString(int n) {
    String binNumAsString = "";

    int addDigit = n;
    if (n >= 0) {
      for (int i = 0; i < STRING_LENGTH; i++) {
        if (addDigit % 2 == 0) {
          binNumAsString = "0" + binNumAsString;
        } else if (addDigit % 2 == 1){
        binNumAsString = "1" + binNumAsString;
        }
        addDigit /= 2;
//        System.out.print(i + ".: " + binNumAsString + " ");
      }
    } else if (n < 0) {
      int otherNumber = Math.abs(n) - 1;
      for (int i = 0; i < STRING_LENGTH; i++) {
        if (otherNumber % 2 == 0) {
          binNumAsString = "1" + binNumAsString;
        } else if (otherNumber % 2 == 1) {
          binNumAsString = "0" + binNumAsString;
        }
        otherNumber /= 2;
      }
      System.out.println();
    }
    return binNumAsString;
  }

}
