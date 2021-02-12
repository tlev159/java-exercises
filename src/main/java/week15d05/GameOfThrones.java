package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {

  public String getHouse(BufferedReader reader) throws IOException {
    reader.readLine();
    Map<String, Integer> numberOfHouses = new HashMap<>();
    String line;
    while ((line = reader.readLine()) != null) {
      List<String> houses = addPartsToList(line);
      countNumberOfHouses(numberOfHouses, houses);
    }
    String nameOfHouse = selectMaxBattledHouse(numberOfHouses);
    return nameOfHouse;
  }

  private String selectMaxBattledHouse(Map<String, Integer> numberOfHouses) {
    int max = Integer.MIN_VALUE;
    String nameOfHouse = null;

    for (Map.Entry<String, Integer> entry : numberOfHouses.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        nameOfHouse = entry.getKey();
      }
    }
    return nameOfHouse;
  }

  private void countNumberOfHouses(Map<String, Integer> numberOfHouses, List<String> houses) {
    for (String house : houses) {
      if (!numberOfHouses.containsKey(house)) {
        numberOfHouses.put(house, 1);
      } else {
        numberOfHouses.put(house, numberOfHouses.get(house) + 1);
      }
    }
  }

  private List<String> addPartsToList(String line) {
    String[] parts = line.split(",");
    List<String> houses = new ArrayList<>();
    for (int i = 5; i < 13; i++) {
      if (!parts[i].isBlank()) {
        houses.add(parts[i]);
      }
    }
    return houses;
  }

  public static void main(String[] args) {
    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/battles.csv"))) {
      String house = new GameOfThrones().getHouse(reader);
      System.out.println(house);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }
}
