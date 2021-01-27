package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

  public void writeAsBytes(List<String> words, Path path) {
    try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))){
      for (String str: words) {
        if (str.charAt(0) != '_') {
          outputStream.write(str.getBytes());
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

}
