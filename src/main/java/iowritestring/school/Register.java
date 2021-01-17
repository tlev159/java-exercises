package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

  public void newMark(Path path, int mark) {
    try {
      if (Files.exists(path)) {
        Files.writeString(path, mark + "\n", StandardOpenOption.APPEND);
      } else {
        Files.writeString(path, Integer.toString(mark));
      }
    } catch(IOException ioe){
      throw new IllegalArgumentException("Can't write file", ioe);
    }
  }

  public void average(Path file) {
    try {
      List<String> marksFrom = Files.readAllLines(file);
      double averageMark = 0.0;
      for (String s:marksFrom) {
        averageMark += Double.parseDouble(s);
      }
      Files.writeString(file, "average: " + averageMark / marksFrom.size() + "\n", StandardOpenOption.APPEND);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!");
    }

  }
}
