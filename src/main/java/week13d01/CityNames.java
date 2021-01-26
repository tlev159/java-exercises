package week13d01;

public class CityNames {

  private int pos;
  private String cityName;
  private String cityPartName;

  public CityNames(int pos, String cityName, String cityPartName) {
    this.pos = pos;
    this.cityName = cityName;
    this.cityPartName = cityPartName;
  }

  public int getPos() {
    return pos;
  }

  public String getCityName() {
    return cityName;
  }

  public String getCityPartName() {
    return cityPartName;
  }
}
