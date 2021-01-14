package week11d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

  public int sumNumbers() {
    String placeholder = "";
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      if (i < 10) {
        placeholder = "0";
      } else {
        placeholder = "";
      }
      String fileName = "number" + placeholder + i + ".txt";
      sum += readFile(fileName);
    }
    return sum;
  }

  public int readFile(String fileName) {
    int readedNumber = 0;
    Path path = Path.of("src/main/java/week11d04/" + fileName);
    if (Files.isRegularFile(path)) {
      try {
        readedNumber = Integer.parseInt(Files.readString(path));
      } catch (IOException ioe) {
        throw new IllegalStateException("Can not read the file", ioe);
      }
    }
    return readedNumber;
  }

  public static void main(String[] args) {
    FilesSum fs = new FilesSum();
    System.out.println("Eredmény: " + fs.sumNumbers());
  }
}
