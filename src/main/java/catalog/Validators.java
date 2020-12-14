package catalog;

import java.util.List;

public class Validators {

  public static boolean isBlank(String str) {
    if(str == null || "".equals(str.trim())) {
      return true;
    }
    return false;
  }

  public static boolean isEmpty(List<String> stringList) {
    if(stringList == null || stringList.size() == 0) {
      return true;
    }
    return false;
  }
}
