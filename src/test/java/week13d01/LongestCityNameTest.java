package week13d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCityNameTest {

  @Test
  void readCitiesFromFile() {
    LongestCityName lcn = new LongestCityName();

    assertEquals("Jászfelsőszentgyörgy", lcn.findLongestCityNameFromFile("cities.csv"));
  }
}