package week11d04;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

  public int sumNumbers() {
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      String fileName = String.format("number%02d.txt", i);
//      String fileName = "number" + (i < 10 ? "0" + i : i);
      sum += readFile(fileName);
    }
    return sum;
  }

  public int readFile(String fileName) {
    int readedNumber = 0;
    String sepChar = FileSystems.getDefault().getSeparator();
    String relativPath = "src" + sepChar + "main" + sepChar + "resources" + sepChar + "week11d04" + sepChar;
    Path path = Path.of(relativPath + fileName);
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
