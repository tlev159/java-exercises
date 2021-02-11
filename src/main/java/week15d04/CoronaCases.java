package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CoronaCases {

  public List<Corona> coronaCases = new ArrayList<>();

  public void readDatasFromFile(Path path, String country) {
    try (BufferedReader reader = Files.newBufferedReader(path)){
      String line = reader.readLine();
      while ((line = reader.readLine()) != null) {
        addDataToList(line, country);
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }

  private void addDataToList(String line, String country) {
    String[] d = line.split(",");
    if (d[4].equals(country)) {
      coronaCases.add(new Corona(d[1], Integer.parseInt(d[2]), d[4]));
    }
  }

  public List<Corona> mostlyCases() {
    List<Corona> result = new ArrayList<>(coronaCases);
    Collections.sort(result);
    return new ArrayList<>(result.subList(0, 3));
  }


  public static void main(String[] args) {
    Path path = Path.of("src/main/resources/data.csv");
    CoronaCases cc = new CoronaCases();
    cc.readDatasFromFile(path, "Hungary");
    System.out.println(cc.mostlyCases());
  }

  public List<Corona> getCoronaCases() {
    return coronaCases;
  }
}
