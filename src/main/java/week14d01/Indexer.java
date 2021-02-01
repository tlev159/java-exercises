package week14d01;

import java.util.*;

public class Indexer {

  public static void main(String[] args) {
    System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Agnes", "Lajos")));
  }

  public Map<Character, List<String>> index(List<String> names) {
    Map<Character, List<String>> resultMap = new HashMap<>();
    for (String name : names) {
      Character firstChar = name.charAt(0);
      if (!resultMap.containsKey(firstChar)) {
        resultMap.put(firstChar, new ArrayList<>());
      }
      resultMap.get(firstChar).add(name);
    }
    return resultMap;
  }
}

