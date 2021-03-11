package properties;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {

  private static final String ENCODING_UTF_8 = "UTF-8";
  private Properties properties;

  public DatabaseConfiguration() {
    try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
      loadProperties(is);
    }
    catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }
  }

  public DatabaseConfiguration(File file) {
    try (FileInputStream fis = new FileInputStream(file)) {
      loadProperties(fis);
    }
    catch (IOException ioe) {
      throw new IllegalArgumentException("Cannot read file", ioe);
    }
  }

  private void loadProperties(InputStream is) {
    properties = new Properties();
    try (InputStreamReader isr = new InputStreamReader(is, ENCODING_UTF_8)) {
      properties.load(isr);
    }
    catch (IOException ie) {
      throw new IllegalArgumentException("Cannot read file", ie);
    }
  }

  public String getHost() {
    return properties.getProperty("db.host");
  }

  public int getPort() {
    return Integer.parseInt(properties.getProperty("db.port"));
  }

  public String getSchema() {
    return properties.getProperty("db.schema");
  }
}
