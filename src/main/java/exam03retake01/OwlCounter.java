package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

  private Map<String, Integer> owls = new HashMap<>();

  public void readFromFile(BufferedReader reader) throws IOException {
    String line;
    while ((line = reader.readLine()) != null) {
      String[] temp = line.split("=");
      if (!owls.containsKey(temp[0])) {
        owls.put(temp[0], Integer.parseInt(temp[1]));
      }
    }
  }

  public int getNumberOfOwls(String country) {
    int result = 0;
    boolean isTown = false;
    for (Map.Entry<String, Integer> temp : owls.entrySet()) {
      if (temp.getKey().equals(country)) {
        result = temp.getValue();
        isTown = true;
      }
    }
    if (isTown) {
      return result;
    }
    throw new IllegalArgumentException("No country with the name \"" + country + "\" found!");
  }

}
