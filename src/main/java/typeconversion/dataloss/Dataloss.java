package typeconversion.dataloss;

import org.w3c.dom.ls.LSOutput;

import static java.lang.Integer.toBinaryString;

public class Dataloss {

//  int a = 2_147_483_647;

  public static void main(String[] args) {
    long b = 2_147_483_649L;
    float c = (float) b;
    long d = (long) c;
    System.out.print("long: " + b + " long => float: " + c + "float => long: " + d);
    System.out.println();
    System.out.print("long: " + Long.toBinaryString(b) + " long => float: " + c + "float => long: " + Long.toBinaryString(d));
    System.out.println();
    long e = -2_147_483_649L;
    float f = (float) b;
    long g = (long) c;
    System.out.print("long: " + e + " long => float: " + f + "float => long: " + g);
    System.out.println();
    System.out.print("long: " + Long.toBinaryString(e) + " long => float: " + f + "float => long: " + Long.toBinaryString(g));
    System.out.println();
    long h = 2_147_483_650L;
    float i = (float) b;
    long j = (long) c;
    System.out.print("long: " + h + " long => float: " + i + "float => long: " + j);
    System.out.println();
    System.out.print("long: " + Long.toBinaryString(h) + " long => float: " + i + "float => long: " + Long.toBinaryString(j));
    System.out.println();

  }
}
