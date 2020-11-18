package literals;

public class LiteralsMain {

  public static void main(String[] args) {

    String a = "1";
    int b = 2;
    System.out.println("1" + 2);
    System.out.println("1" + "2");
    System.out.println("12");
    System.out.println(a + 2);
    System.out.println(a + b);

    double quotient = 3.0 / 4;
    System.out.println(quotient);

    long big = 3_244_444_444L;

    String s = "árvíztűrőtükörfúrógép";

    String word = "title".toUpperCase();

    int d = 1;
    int e = -2;

    System.out.println(Integer.toBinaryString(d));
    System.out.println(Integer.toBinaryString(e));


  }
}
