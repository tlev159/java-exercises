package coronaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupRegistration {

  public static final String SEPARATE = ";";

  private List<Citizens> citizens = new ArrayList<>();


  public void readRegistrationDataFromFile(BufferedReader reader) {
    String line;
    try {
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        String[] temp = line.split(SEPARATE);
        String fullName = temp[0];
        int zip = Integer.parseInt(temp[1]);
        int age = Integer.parseInt(temp[2]);
        String email = temp[3];
        String taj = temp[4];
        citizens.add(new Citizens(fullName, zip, age, email, email, taj));
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read the file!", ioe);
    }
  }

  public List<Citizens> getCitizens() {
    return citizens;

  }
}
