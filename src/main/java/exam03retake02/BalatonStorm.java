package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

  private static final String KEY_VALUE_SEP = ":";


  public List<String> getStationsInStorm(BufferedReader reader) {
    List<String> stationsInStorm = new ArrayList<>();
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        readStationNameAndSaveToTemp(reader, stationsInStorm, line);
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read", ioe);
    }
    Collections.sort(stationsInStorm, Collator.getInstance(new Locale("hu", "HU")));
    return new ArrayList<>(stationsInStorm);
  }

  private void readStationNameAndSaveToTemp(BufferedReader reader, List<String> stationsInStorm, String line) throws IOException {
    String[] temp = line.split(KEY_VALUE_SEP);
    if (temp[0].contains("allomas")) {
      String station = temp[1].trim().substring(1,temp[1].length() - 3);
      for (int i = 0; i < 3; i++) {
        reader.readLine();
      }
      isLevelOfStormAddStationToList(reader, stationsInStorm, station);
    }
  }

  private void isLevelOfStormAddStationToList(BufferedReader reader, List<String> stationsInStorm, String station) throws IOException {
    String line;
    line = reader.readLine();
    int stormLevel = Integer.parseInt((line.split(KEY_VALUE_SEP))[1].trim().substring(0,1));
    if (stormLevel == 3) {
    stationsInStorm.add(station);
    }
  }

}
