package inheritanceconstructor.cars;

public class Car {
  private double fuelRate;
  private double fuel;
  private double tankCapacity;

  public Car(double fuelRate, double fuel, double tankCapacity) {
    if (fuel > tankCapacity) {
      throw new IllegalArgumentException("Tank capacity is less than fuel!");
    }
    this.fuelRate = fuelRate;
    this.fuel = fuel;
    this.tankCapacity = tankCapacity;
  }

  public void modifyFuelAmount(double fuel) {
    this.fuel += fuel;
  }

  public void drive(int km) {
    if (canDriveThisKm(km)) {
      throw new IllegalArgumentException("Not enough fuel available!");
    } else {
      fuel -= fuelRate * km / 100.0;
    }
  }

  public boolean canDriveThisKm(int km) {
    return (fuel - fuelRate * km / 100.0 <= 0);
  }


  public double calculateRefillAmount() {
    return tankCapacity - fuel;
  }

  public double getFuelRate() {
    return fuelRate;
  }

  public double getFuel() {
    return fuel;
  }

  public double getTankCapacity() {
    return tankCapacity;
  }
}
