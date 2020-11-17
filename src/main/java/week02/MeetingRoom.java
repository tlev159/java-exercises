package week02;

public class MeetingRoom {

  private String name;
  private int length;
  private int width;


  public MeetingRoom(String name, int length, int width) {

    this.name = name;
    this.length = length;
    this.width = width;
  }

  public int getArea() {
    int area = getLength() * getWidth();
    return area;
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setWidth(int width) {
    this.width = width;
  }

}
