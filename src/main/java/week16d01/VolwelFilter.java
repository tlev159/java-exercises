package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VolwelFilter {

  private static final char[] filtered = {'a','A', 'á', 'Á', 'e', 'E', 'é', 'É', 'i', 'I', 'í', 'Í', 'o','O',
          'ó', 'Ó', 'ö', 'Ö', 'ő', 'Ő', 'u', 'U', 'ú', 'Ú', 'ü', 'Ü', 'ű', 'Ű'};

  public String readFromFile(BufferedReader reader) throws IOException {
    String line;
    StringBuilder sb = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      generateResultedString(line, sb);
    }
    return sb.toString();
  }

  private void generateResultedString(String line, StringBuilder sb) {
    for (char c : line.toCharArray()) {
      boolean isInclude = true;
      filterCharacter(sb, c, isInclude);
    }
    sb.append('\n');
  }

  private void filterCharacter(StringBuilder sb, char c, boolean isInclude) {
    for (char f : filtered) {
      if (c == f) {
        isInclude = false;
      }
    }
    if (isInclude) {
      sb.append(c);
    }
  }

  public static void main(String[] args) {
    VolwelFilter vf = new VolwelFilter();
    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/week16d01-01.txt"))) {
      String result = vf.readFromFile(reader);
      System.out.println(result);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }


}
