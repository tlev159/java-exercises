package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

  private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  private List<State> states = new ArrayList<>();

  public void readStatesFromFile(String fileName) {
    Path file = Path.of("src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + fileName);

    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] stateAndCapitol = line.split("-");
        states.add(new State(stateAndCapitol[0], stateAndCapitol[1]));
      }
    }
    catch (IOException ioe) {
      throw new IllegalStateException("Can't read file!", ioe);
    }
  }

  public String findCapitalByStateName(String stateName) {
    String result = "";
    try {
      for (State state:states) {
        if (state.getStateName().equals(stateName)) {
          result = state.getCapital();
        }
      }
      return result;
    }
    catch (IndexOutOfBoundsException ioobe) {
      throw new IllegalArgumentException("No state with this name!", ioobe);
    }
  }

  public List<State> getStates() {
    return new ArrayList<>(List.copyOf(states));
  }
}
