package virtualmethod.vehicle;

public class Car  extends Vehicle {

  private int numberPassenger;

  public Car(int numberPassenger, int vehicleWeight) {
    super(vehicleWeight);
    this.numberPassenger = numberPassenger;
  }

  @Override
  public int getGrossLoad() {
    return super.getGrossLoad() + (numberPassenger * PERSON_AVERAGE_WEIGHT);
  }

  @Override
  public String toString() {
    return "Car{" +
        "numberOfPassenger=" + numberPassenger +
        ", " + "vehicleWeight=" + getVehicleWeight() +
        '}';
  }

  public int getNumberPassenger() {
    return numberPassenger;
  }
}
