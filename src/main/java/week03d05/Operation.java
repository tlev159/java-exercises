package week03d05;

public class Operation {

  private int leftValue;
  private int rightValue;

  public Operation(String stringOf) {
    this.leftValue = Integer.parseInt(valueLeft(stringOf));
    this.rightValue = Integer.parseInt(valueRigth(stringOf));
  }

  public String valueLeft(String s) {
    String leftValueS = s.substring(0, s.indexOf("+"));
    return leftValueS;
  }

  public String valueRigth(String s) {
    String rightValueS = s.substring(s.indexOf("+")+1);
    return rightValueS;
  }

  public int getResult() {
    return leftValue + rightValue;
  }
}