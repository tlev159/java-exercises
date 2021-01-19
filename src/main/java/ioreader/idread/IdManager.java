package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

  private List<String> ids = new ArrayList<>();

  public void readIdsFromFile(String pathString) {
    String defSep = FileSystems.getDefault().getSeparator();
    Path file = Path.of("src" + defSep + "main" + defSep + "resources" + defSep + pathString);
    try (BufferedReader reader = Files.newBufferedReader(file)) {
      String line;
      while ((line = reader.readLine()) != null) {
        ids.add(line);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Can not read file" , e);
    }
  }

  public List<String> getIds() {
    return new ArrayList<>(List.copyOf(ids));
  }
}
