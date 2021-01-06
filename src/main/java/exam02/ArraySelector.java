package exam02;

public class ArraySelector {

  public String selectEvens(int[] ints) {
    if (ints.length == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < ints.length; i += 2) {
      sb.append(ints[i]).append(", ");
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append("]");
    return sb.toString();
  }

}
