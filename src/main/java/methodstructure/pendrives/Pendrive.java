package methodstructure.pendrives;

public class Pendrive {

  private String name;
  private int capacity;
  private int price;

  public Pendrive(String name, int capacity, int price) {
    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Name must not be null or empty!");
    }
    this.name = name;
    if (capacity < 1) {
      throw new IllegalArgumentException("Capacity must be positive!");
    }
    this.capacity = capacity;
    if (price < 0) {
      throw new IllegalArgumentException("Price must be positive!");
    }
    this.price = price;
  }

  public void risePrice(int percent) {
    price += percent * price / 100;
  }

  public int comparePricePerCapacity(Pendrive pd) {
    double thisPendrive = (double) this.getPrice()/this.getCapacity();
    double givenPendrive = (double) pd.price/pd.capacity;
    if (thisPendrive > givenPendrive) {
      return 1;
    } else if (thisPendrive < givenPendrive) {
      return -1;
    } else {
      return 0;
    }
  }

  public boolean cheaperThan(Pendrive pd) {
    return this.price < pd.getPrice();
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Pendrive{" +
            "name='" + name + '\'' +
            ", capacity=" + capacity +
            ", price=" + price +
            '}';
  }
}
