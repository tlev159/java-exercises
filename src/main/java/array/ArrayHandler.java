package array;

import java.util.ArrayList;

public class ArrayHandler {

  public boolean contains(int[] source, int itemToFind) {
    for (int i: source) {
      if (itemToFind == i) {
        return true;
//        System.out.println("A tömb tartalmazza a keresett elemet!");
      }
//        System.out.println("A tömb nem tartalmazza a keresett elemet!");
    }
    return false;
  }

  public int find(int[] source, int itemToFind) {
    for (int i = 0; i < source.length; i++) {
      if (itemToFind == source[i]) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayHandler arrayHandler = new ArrayHandler();

    int[] sourceInt = {3, 6, 7, 10, 33, 54};
    System.out.println(arrayHandler.contains(sourceInt, 32));
    System.out.println(arrayHandler.find(sourceInt, 10));
  }

}
