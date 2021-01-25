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

  public void readTalents(Path file) {
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] pr = line.split(" ");
        Production p = new Production(Integer.parseInt(pr[0]), pr[1]);
        productions.add(p);
//        productions.add(new Production(Integer.parseInt(pr[0]), pr[1]));
      }
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
