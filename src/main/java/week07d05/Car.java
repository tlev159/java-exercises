package week07d05;

public class Car extends Vehicle{

  Vehicle car = new Car(5,TransmissionType.AUTOMATIC);

  public Car(int numberOfGears, TransmissionType transmissionType) {
    super(numberOfGears, transmissionType);
  }
}
