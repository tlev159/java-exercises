package week07d05;

public class Truck extends Vehicle {

  public Truck() {
  }

  public Truck(TransmissionType transmissionType) {
    super(transmissionType);
  }

  public Truck(int numberOfGears, TransmissionType transmissionType) {
    super(numberOfGears, transmissionType);
  }
}
