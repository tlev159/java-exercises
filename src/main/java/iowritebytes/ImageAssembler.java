package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

  public void makeImageFile(byte[][] bytes, Path path) {
    Path file = path.resolve("image.png");
    try (BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
      for (byte[] bytePart:bytes) {
        outputStream.write(bytePart);
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write the file!");
    }
  }
}
