package classstructuremethods;

public class ClientMain {

  public static void main(String[] args) {
    Client client = new Client();

    client.setName("John Doe");
    client.setYear(1990);
    client.setAddress("6100 Kkfháza, Valami u. 5.");

    System.out.println("Name: " + client.getName());
    System.out.println("Year: " + client.getYear());
    System.out.println("Address: " + client.getAddress());

    client.migrate("6000, Kmét, AHA u. 4.");
    System.out.println("A cím módosítva! Az új cím:" + client.getAddress());

  }
}
