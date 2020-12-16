package week08d03;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class StringList {

  public List<String> stringListsUnion(List<String> first, List<String> second) {
    List<String> result = first;
      for (String b:second) {
        if (!result.contains(b)) {
          result.add(b);
        }
    }
    return result;
  }
}
