package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Bucketlist {

  public static void main(String[] args) {

    try {
      Scanner scanner = new Scanner(Path.of("bucketlist.txt"));

      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      }

    } catch (IOException e) {
      throw new IllegalArgumentException("Can not read file!", e);
    }
  }
}
