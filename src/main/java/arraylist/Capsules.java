package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {

  List<String> capsules = new ArrayList<>();

  public void addLast(String addColor) {
    capsules.add(addColor);
  }

  public void addFirst(String addColor) {
    capsules.add(0, addColor);
  }
  public void removeFirst() {
    capsules.remove(0);
  }
  public void removeLast() {
    capsules.remove(capsules.size()-1);
  }

  public List<String> getColors() {
    return capsules;
  }

  public static void main(String[] args) {
    Capsules capsules = new Capsules();

    capsules.addFirst("barna");
    capsules.addFirst("kék");
    capsules.addFirst("bordó");
    capsules.addFirst("lila");
    capsules.addFirst("sárga");
    capsules.addLast("fekete");
    capsules.addLast("fehér");
    System.out.println(capsules.getColors());
    capsules.removeFirst();
    System.out.println(capsules.getColors());
    capsules.removeLast();
    System.out.println(capsules.getColors());


  }
}
