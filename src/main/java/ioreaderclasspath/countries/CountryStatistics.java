package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

  private List<Country> countryList = new ArrayList<>();

  public void readFromFile(String pathName) {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + pathName)))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] countryLine = line.split(" ");
        countryList.add(new Country(countryLine[0], Integer.parseInt(countryLine[1])));
      }
    }
    catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!");
    }
  }

  public int numberOFCountries() {
    return countryList.size();
  }

  public Country mostBorderCountries() {
    Country country = countryList.get(0);
    for (Country country1:countryList) {
      if (country.getBorderCountries() < country1.getBorderCountries()) {
        country = country1;
      }
    }
    return country;
  }

  public List<Country> getCountryList() {
    return new ArrayList<>(countryList);
  }
}
