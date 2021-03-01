package coronaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupRegistration {

  public static final String SEPARATE = ";";

  private List<Citizens> citizens = new ArrayList<>();

  public List<Citizens> readRegistrationDataFromFile(BufferedReader reader, CoronaDao coronaDao) throws IOException {
    CitizenValidation citizenValidation = new CitizenValidation();
    String line;
    reader.readLine();
    int proofedLine = 1;
    List<Integer> failedRows = new ArrayList<>();
    while ((line = reader.readLine()) != null) {
      String[] temp = line.split(SEPARATE);
      String fullName = temp[0];
      int zip = Integer.parseInt(temp[1]);
      int age = Integer.parseInt(temp[2]);
      String email = temp[3];
      String taj = temp[4];
      if (citizenValidation.validationForFileRows(fullName, zip, age, email, taj, coronaDao)) {
        citizens.add(new Citizens(fullName, zip, age, email, taj));
      } else {
        failedRows.add(proofedLine);
      }
      proofedLine++;
    }
    if (failedRows.size() != 0) {
      System.out.println("A következő sorok hibásak:");
      System.out.println(Arrays.asList(failedRows));
    }
    return citizens;
  }

  public List<Citizens> getCitizens() {
    return citizens;

  }
}
