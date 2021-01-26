package ioreaderbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

  public int readBytesAndFindAs(String fileName) {
    Path file = Path.of(fileName);
    int sumOfAs = 0;
    try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
      byte[] bytes = new byte[1000];
      int size;
      while ((size = inputStream.read(bytes)) > 0) {
        sumOfAs += countA(bytes);
      }
      return sumOfAs;
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file");
    }
  }

  private int countA(byte[] bytes) {
    int countA = 0;
    for (byte b:bytes) {
      if (b == (byte) 'a') {
        countA++;
      }
    }
    return countA;
  }
}
