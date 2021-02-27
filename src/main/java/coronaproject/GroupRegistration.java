package coronaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupRegistration {

  public static final String SEPARATE = ";";

  private List<Citizens> citizens = new ArrayList<>();

  public List<Citizens> readRegistrationDataFromFile(BufferedReader reader) throws IOException {
    String line;
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        String[] temp = line.split(SEPARATE);
        String fullName = temp[0];
        int zip = Integer.parseInt(temp[1]);
        int age = Integer.parseInt(temp[2]);
        String email = temp[3];
        String taj = temp[4];
        citizens.add(new Citizens(fullName, zip, age, email, taj));
      }
    return citizens;
  }

  public List<Citizens> getCitizens() {
    return citizens;

  }
}
