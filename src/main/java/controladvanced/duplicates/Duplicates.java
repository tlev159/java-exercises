package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

  public List<Integer> find(List<Integer> listOfIntegers) {
    List<Integer> duplicates = new ArrayList<>();
    for (int i = 0; i < listOfIntegers.size(); i++) {
      List<Integer> modifiesList = listOfIntegers.subList(i + 1, listOfIntegers.size());
        if (modifiesList.contains(listOfIntegers.get(i))) {
          duplicates.add(listOfIntegers.get(i));
        }
      }
    return duplicates;
  }
}
