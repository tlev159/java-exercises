package week07d05;

public class Motorcycle extends Vehicle{

  public Motorcycle() {
  }

  public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
    super(numberOfGears, TransmissionType.SEQUENTIAL);
  }
}
