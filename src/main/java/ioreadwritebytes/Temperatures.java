package ioreadwritebytes;

public class Temperatures {

  private byte[] data;

  public Temperatures(byte[] data) {
    this.data = data;
  }

  public double getYearAverage() {
    double yearAverage = 0.0;
    for (int i = 0; i < data.length; i++) {
      yearAverage += data[i];
    }
    return yearAverage / 365.0;
  }

  public double getMonthAverage() {
    double monthAverage = 0.0;
    int dataLength = data.length;
    for (int i = dataLength - 30; i < data.length; i++) {
      monthAverage += data[i];
    }
    return monthAverage / 30.0;
  }

  public byte[] getData() {
    return data;
  }
}
