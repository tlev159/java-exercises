package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class Whitchtype {

  public List<Type> whitchType(String s) {
    Type[] types = Type.values();
    long longNum = Long.parseLong(s);
    List<Type> canBeConvertToLong = new ArrayList<>();
    for (Type num : types) {
      if (longNum < num.getMaxValue() && longNum > num.getMinValue()) {
        canBeConvertToLong.add(num);
      }
    }
    return canBeConvertToLong;
  }
}
