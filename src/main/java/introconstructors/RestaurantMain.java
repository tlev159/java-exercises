package introconstructors;

public class RestaurantMain {

  public static void main(String[] args) {

    Restaurant restaurant = new Restaurant("Óda a vaddisznóhoz", 10);

    restaurant.addMenu("Bécsi szelet");
    restaurant.addMenu("Vadas szelet");
    restaurant.addMenu("Gesztenyepüré");
    restaurant.addMenu("Gundel palacsinta");
    restaurant.addMenu("Tárkonyos raguleves");
    restaurant.addMenu("Legényfogó leves");
    restaurant.addMenu("csemegeuborka saláta");

    System.out.println("A(z) \"" + restaurant.getName() + "\" étterem");
    System.out.println(restaurant.getCapacity() + " férőhelyes");
    System.out.println("Menüje:");
    System.out.println(restaurant.getMenu());
  }



}
