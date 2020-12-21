package inheritanceconstructor.cars;

public class Jeep extends Car{

  private double extraCapacity;
  private double extraFuel;

  public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
    super(fuelRate, fuel, tankCapacity);
    this.extraCapacity = extraCapacity;
    this.extraFuel = extraFuel;
  }

  public void modifyFuelAmount(double fuel) {
    super.modifyFuelAmount(fuel);
  }

  public void drive(int km) {
    if (canDriveThisKm(km)) {
      throw new IllegalArgumentException("Not enough fuel available!");
    } else {
      int newKm = reduceExtraFuel(km);
      super.drive(newKm);
    }
  }

  private int reduceExtraFuel(int km) {
    double toUsedFuel = getFuelRate() * km / 100.0;
    if (extraFuel > 0 && toUsedFuel <= extraFuel) {
      extraFuel -= toUsedFuel;
      return 0;
    } else  if (extraFuel > 0 && toUsedFuel > extraFuel) {
      toUsedFuel -= extraFuel;
      extraFuel = 0.0;
      int canDriveKm = (int) (toUsedFuel * 100 / getFuelRate());
      return canDriveKm;
    }
    return km;
  }

  public boolean canDriveThisKm(int km) {
    double totalCapacity = getTankCapacity() + extraCapacity;
    double totalFuel = getFuel() + extraFuel;
    return totalFuel - km * getFuelRate() / 100.0 <= 0;
  }

  public double calculateRefillAmount() {
    double totalCapacity = getTankCapacity() + extraCapacity;
    double totalFuel = getFuel() + extraFuel;
    return totalCapacity - totalFuel;
  }

  public double getExtraCapacity() {
    return extraCapacity;
  }

  public double getExtraFuel() {
    return extraFuel;
  }
}
