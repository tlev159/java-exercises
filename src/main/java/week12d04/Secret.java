package week12d04;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {

  private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

  public void readSecretBinary(String pathString) {
    String pathOfFile = "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + pathString;
    Path file = Path.of(pathOfFile);
    System.out.println();
    try {
      byte[] bytes = Files.readAllBytes(file);
      for (Byte b:bytes) {
        System.out.print((char)(b + 10));
      }
      System.out.println();
    }
    catch (IOException i) {
      throw new IllegalStateException("Can not read binary file!", i);
    }
  }

  public static void main(String[] args) {
    new Secret().readSecretBinary("secret.dat");

  }
}
