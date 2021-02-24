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
    for (Map.Entry<String, Integer> temp : owls.entrySet()) {
      if (temp.getKey().equals(country)) {
        return temp.getValue();
      }
    }
    throw new IllegalArgumentException("No country with the name \"" + country + "\" found!");
  }

}
