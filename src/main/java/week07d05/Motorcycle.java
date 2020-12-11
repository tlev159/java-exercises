package week07d05;

public class Motorcycle extends Vehicle{

  public Motorcycle() {
  }

  public Motorcycle(int numberOfGears) {
    super(numberOfGears, TransmissionType.SEQUENTIAL);
  }

  public Motorcycle(TransmissionType transmissionType) {
    super(transmissionType);
  }

  public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
    super(numberOfGears, transmissionType);
  }
}
