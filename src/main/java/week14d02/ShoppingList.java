package week14d02;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ShoppingList {

  private Map<String, TreeSet<String>> ordersMap = new HashMap<>();

  public void getDatasFromList(BufferedReader reader) throws IOException {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] splittedLine = line.split(" ");
        TreeSet<String> products = new TreeSet<>();
        Collections.addAll(products, splittedLine[1].split(","));
        ordersMap.put(splittedLine[0], products);
      }
  }

  public TreeSet<String> getProductsOrderedById(String id) {
    return ordersMap.get(id);
  }

  public Map<String, Integer> getProductsMap() {
    Map<String, Integer> productMap = new HashMap<>();
    for (TreeSet<String> set : ordersMap.values()) {
      for (String item : set) {
        if (!productMap.containsKey(item)) {
          productMap.put(item, 1);
        } else {
          productMap.put(item, productMap.get(item) + 1);
        }
      }
    }
    return productMap;
  }

  public int getNumberOfOrderedProducts(String product) {
    return getProductsMap().get(product);
  }

  public int getNumberByOrderId(String id) {
    return getProductsOrderedById(id).size();
  }


  public static void main(String[] args) {
    ShoppingList shoppingList = new ShoppingList();
    try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/shoppinglist.txt"))) {
      shoppingList.getDatasFromList(reader);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
    System.out.println(shoppingList.ordersMap);
    System.out.println(shoppingList.getProductsOrderedById("A312")); // 1.
    System.out.println(shoppingList.getNumberOfOrderedProducts("sugar")); // 2.
    System.out.println(shoppingList.getNumberByOrderId("A312")); // 3.
    System.out.println(shoppingList.getProductsMap()); // 4.
  }
}
