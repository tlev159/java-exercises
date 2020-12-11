package week07d05;

public class Vehicle {

  private int NumberOfGears;
  private TransmissionType transmissionType;

  public Vehicle() {
  }

  public Vehicle(int numberOfGears, TransmissionType transmissionType) {
    NumberOfGears = numberOfGears;
    this.transmissionType = transmissionType;
  }

  public int getNumberOfGears() {
    return NumberOfGears;
  }

  public TransmissionType getTransmissionType() {
    return transmissionType;
  }
}
