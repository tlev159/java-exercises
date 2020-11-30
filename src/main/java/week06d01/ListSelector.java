package week06d01;

import java.util.List;

public class ListSelector {

  public String selectFromList(List<String> stringList) {
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < stringList.size(); i+=2) {
        sb.append(stringList.get(i));
      }
      sb.append("]");
      return sb.toString();
    } catch (NullPointerException npe) {
      throw new IllegalArgumentException("Empty String list!", npe);
    }
  }

}
