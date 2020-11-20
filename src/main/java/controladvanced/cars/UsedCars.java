package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {

  public List<String> filterLines(List<String> lines) {
    List<String> validlines = new ArrayList<>();
    for (String line: lines) {
      String[] parts = line.split(";");
      if (parts.length != 4) {
        continue;
      } else {
        if (parts[0].length() == 7 &&
            parts[0].indexOf("-") > 0 &&
            parts[0].indexOf("-") < 7 &&
            Integer.parseInt(parts[1]) < 2019 &&
            Integer.parseInt(parts[1]) > 1970) {
          validlines.add(line);
        }
      }
    }
    return validlines;
  }
}
