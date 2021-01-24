package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

  private List<Band> bands = new ArrayList<>();

  public void readBandsFromFile(Path inputFile) {
    try (BufferedReader reader = Files.newBufferedReader(inputFile)){
      String line;
      String bandName;
      int year;
      if ((line = reader.readLine()) != null) {
        bandName = line.split(";")[0];
        year = Integer.parseInt(line.split(";")[1]);
        bands.add(new Band(bandName, year));
      }
    }
    catch (IllegalArgumentException | IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }

  }

  public void writeBandsBefore(Path outputFile, int year) {
    List<String> listOfBands = selectBandsBefore(year);
    try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.APPEND)){
      for (String line:listOfBands) {
        writer.write(line + "\n");
      }
    }
    catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

  private List<String> selectBandsBefore(int year) {
    List<String> outputs = new ArrayList<>();
    for (Band b:bands) {
      if (b.getYear() > year) {
        outputs.add(b.getName() + ", " + b.getYear());
      }
    }
    return outputs;
  }

}
