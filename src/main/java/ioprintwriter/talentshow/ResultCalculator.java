package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

  private List<Production> productions = new ArrayList<>();
  private List<Vote> votes = new ArrayList<>();

  public void readTalents(Path path) {
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      String line;
      int i = 1;
      while ((line = reader.readLine()) != null);
        productions.add(new Production(i, line));
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file", ioe);
    }
  }


  public List<Production> getProductions() {
    return productions;
  }

  public List<Vote> getVotes() {
    return votes;
  }
}
