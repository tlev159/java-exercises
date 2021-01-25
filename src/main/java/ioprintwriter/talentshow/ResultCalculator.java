package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
      int id = 0;
      while ((line = reader.readLine()) != null) {
        String[] pr = line.split(" ");
        id = Integer.parseInt(pr[0]);
        productions.add(new Production(id, pr[1]));
        votes.add(new Vote(id, 0));
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file", ioe);
    }
  }

  public void calculateVotes(Path file) {
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while ((line = reader.readLine()) != null) {
        votes.get(Integer.parseInt(line) - 1).incNum();
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file", ioe);
    }
  }

  public void writeResultToFile(Path file) {
    try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
      printRowsToFile(pw);
      printWinnerToFileEnd(pw);
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file", ioe);
    }
  }

  private void printRowsToFile(PrintWriter pw) {
    for (int i = 0; i < productions.size(); i++) {
      pw.print(productions.get(i).getId());
      pw.print(" ");
      pw.print(productions.get(i).getName());
      pw.print(" ");
      pw.println(votes.get(i).getNumber());
    }
  }

  private void printWinnerToFileEnd(PrintWriter pw) {
    int winnerId = whatIsTheWinnersId();
    pw.print("Winner: ");
    pw.println(productions.get(winnerId - 1).getName());
  }

  private int whatIsTheWinnersId() {
    int maxVoteId = votes.get(0).getId();
    for (Vote v:votes) {
      if (v.getNumber() > votes.get(maxVoteId).getNumber()) {
        maxVoteId = v.getId();
      }
    }
    return maxVoteId;
  }
  public List<Production> getProductions() {
    return productions;
  }

  public List<Vote> getVotes() {
    return votes;
  }
}
