package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

  public void writeTo(List<String> str, Writer writer) {
    try {
      for (String s:str) {
        writer.write(s);
        writer.write(s.length() + "\n");
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }

  }

  public String writeWithStringWriter(List<String> words) {
    StringWriter sw = new StringWriter();
    try (sw) {
        writeTo(words, sw);
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
    return sw.toString();
  }
}
