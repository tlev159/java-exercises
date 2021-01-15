package ioreadstring.names;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

  private Path myFile;
  private List<Human> humans = new ArrayList<>();

  public FileManager(String myFile) {
    this.myFile = Path.of(myFile);
  }

//  String sep = FileSystems.getDefault().getSeparator();
//  Path path = Path.of("src" + sep + "main" + sep + "resources" + sep + "names.txt");

  public void readFromFile() {
      try {
          List<String> names= Files.readAllLines(myFile);
          for (String name:names) {
            String[] fullName = name.trim().split(" ");
            humans.add(new Human(fullName[0].trim(), fullName[1].trim()));
          }
      } catch (IOException e) {
          throw new IllegalArgumentException("Invalid name or can't read the file!", e);
      }
  }

  public Path getMyFile() {
    return myFile;
  }

  public List<Human> getHumans() {
    return new ArrayList<>(humans);
  }
}
