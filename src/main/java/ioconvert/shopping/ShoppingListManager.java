package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

  public void saveShoppingList(OutputStream os, List<String> shoppingList) {
    try (PrintStream ps = new PrintStream(new BufferedOutputStream(os))) {
      for (String shopping : shoppingList) {
        ps.println(shopping);
      }
    }
  }

  public List<String> loadShoppingList(InputStream is) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      List<String> shoppingList = new ArrayList<>();
      String line;
      while ((line = br.readLine()) != null) {
        shoppingList.add(line);
      }
      return shoppingList;
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe
      );
    }
  }
}
