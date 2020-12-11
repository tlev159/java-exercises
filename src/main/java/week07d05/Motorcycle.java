package week07d05;

public class Motorcycle extends Vehicle{

  Vehicle motorcycle = new Motorcycle(5, TransmissionType.SEQUENTIAL);

  public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
    super(numberOfGears, transmissionType);
  }
}
