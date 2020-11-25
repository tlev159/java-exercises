package stringbasic.stringbasic;

public class StringCreator {

  public String createStringForHeap() {
    String a = new String("abc");
    return a;
  }

  public String createStringForPool() {
  String b = "abc";
  return b;
  }

}
