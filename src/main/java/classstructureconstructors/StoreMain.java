package classstructureconstructors;

import java.util.Scanner;

public class StoreMain {

  public static void main(String[] args) {
    Store store1 = new Store("alma");
    Store store2 = new Store("alma");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kérem az 1-es raktárba beérkezett készlet mennyiségét!");
    store1.store(scanner.nextInt());

    System.out.println("Kérem az 1-es raktárból kiszálított készlet mennyiségét!");
    store1.dispatch(scanner.nextInt());

    System.out.println("Kérem a 2-es raktárba beérkezett készlet mennyiségét!");
    store2.store(scanner.nextInt());

    System.out.println("Kérem a 2-es raktárból kiszálított készlet mennyiségét!");
    store2.dispatch(scanner.nextInt());

    System.out.println("Az 1-es raktár készlete: " + store1.getStock());
    System.out.println("A 2-es raktár készlete: " + store2.getStock());
  }
}
