package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

  private static final String NAME = "name";
  private static final String URL = "url";

  private Properties properties;

  public JavaTools() {
    properties = new Properties();
    try (InputStream inputStream = JavaTools.class.getResourceAsStream("/javatools.properties")) {
      properties.load(inputStream);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file", ioe);
    }
  }

  public Set<String> getToolKeys() {
    Set<String> keys = properties.stringPropertyNames();
    Set<String> result = new HashSet<>();

    for (String key : keys) {
      if (key.contains(NAME)) {
        result.add(key.substring(0, key.indexOf(".")));
      }
    }
    return result;
  }

  public Set<String> getTools() {
    Set<String> result = new HashSet<>();

    for (String key : properties.stringPropertyNames()) {
      if (key.contains(NAME)) {
        result.add(properties.getProperty(key));
      }
    }
    return result;
  }

  public String getName(String name) {
    return properties.getProperty(name + "." + NAME);
  }

  public String getUrl(String url) {
    return properties.getProperty(url + "." + URL);
  }

}
