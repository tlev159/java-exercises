package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Corona {

  private static final String SEPARATE = FileSystems.getDefault().getSeparator();

  public int findWordInHtml() {
    int result = 0;
    String fileName = "src" + SEPARATE + "main" + SEPARATE + "resources" + SEPARATE + "week12d05" + SEPARATE + "Index.htm";
    Path file = Path.of(fileName);
    try (BufferedReader br = Files.newBufferedReader(file)){
      String line;
      while ((line = br.readLine()) != null) {
        String[] stringLine = line.split(" ");
        if (line.contains("koronavírus")) {
            result++;
          }
        }
      return result;
      }
    catch (IOException i) {
      throw new IllegalStateException("Can not read file!", i);
    }
  }

  public static void main(String[] args) {
    Corona c = new Corona();
    System.out.println(c.findWordInHtml());
  }
}
