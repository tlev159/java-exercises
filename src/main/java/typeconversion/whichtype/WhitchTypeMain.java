package typeconversion.whichtype;

public class WhitchTypeMain {

  public static void main(String[] args) {
    Whitchtype wT = new Whitchtype();

    System.out.println(wT.whitchType("127"));
    System.out.println(wT.whitchType("126"));
    System.out.println(wT.whitchType("134"));
    System.out.println(wT.whitchType("325874"));
    System.out.println(wT.whitchType("-325874"));
    System.out.println(wT.whitchType("2147483648"));
  }
}
