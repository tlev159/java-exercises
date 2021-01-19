package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

  public Temperatures readTemperatures(String pathString) {
    Path file = Path.of(pathString);
    byte[] temps;
    try {
      temps = Files.readAllBytes(file);
    } catch (IOException e) {
      throw new IllegalStateException("Can not read file", e);
    }
    return new Temperatures(temps);
  }
}
