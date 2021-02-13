package week15d05.gots;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoTs {

  public static void main(String[] args) {
    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/battles.csv"))) {
      reader.readLine();
      String house = new GoTs().getHouse(reader);
      System.out.println(house);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }

  private String getHouse(BufferedReader reader) throws IOException {
    Map<String, Integer> numberOfBattles = new HashMap<>();
    String line;
    while ((line = reader.readLine()) != null) {
      String[] parts = line.split(",");

      List<String> houses = new ArrayList<>();
      for (int i = 5; i < 13; i++) {
        if (!parts[i].isBlank()) {
          houses.add(parts[i]);
        }
      }

      for (String h : houses) {
        if (!numberOfBattles.containsKey(h)) {
          numberOfBattles.put(h, 1);
        } else {
          numberOfBattles.put(h, numberOfBattles.get(h) + 1);
        }

      }

    }
    int max = 0;
    String maxBattledHouse = "";

    for (Map.Entry<String, Integer> entry : numberOfBattles.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        maxBattledHouse = entry.getKey();
      }
    }
    return maxBattledHouse;
  }

}
