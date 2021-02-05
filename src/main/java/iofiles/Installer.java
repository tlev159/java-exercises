package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

  public void install(String pathString) {
    Path target = Path.of(pathString);
    String source = "src/main/resources/install/";
    if (!Files.exists(target) || !Files.isDirectory(target)) {
      throw new IllegalArgumentException("The given directory doesn't exist");
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(source + "install.txt"))))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.indexOf("/") == line.length() - 1) {
          Files.createDirectories(target.resolve(line));
        } else {
          Files.copy(Path.of(source + line), target.resolve(line), StandardCopyOption.REPLACE_EXISTING);
        }
      }

    } catch (IOException ioe) {
      throw new IllegalArgumentException("File or map can not copy!", ioe);
    }
  }

}

