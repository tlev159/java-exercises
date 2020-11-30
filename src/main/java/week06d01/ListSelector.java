package week06d01;

import java.util.List;

public class ListSelector {

  public String selectFromList(List<String> stringList) {
    try {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < stringList.size(); i+=2) {
        sb.append(stringList.get(i));
      }
      return "[" + sb.toString() + "]";
    } catch (NullPointerException npe) {
      throw new IllegalArgumentException("Empty String list!", npe);
    }
  }

//  public String selectFromListWith(List<String> stringList) {
//    try {
//      StringBuilder sb = new StringBuilder();
//      for (int i = 0; i < stringList.size() - 2; i+=2) {
//        sb.append(stringList.get(i)).append(", ");
//      }
//
//      sb.append(stringList.get());
//      return "[" + sb.toString() + "]";
//    } catch (NullPointerException npe) {
//      throw new IllegalArgumentException("Empty String list!", npe);
//    }
//  }
}
