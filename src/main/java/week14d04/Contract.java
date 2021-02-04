package week14d04;

import java.util.List;

public class Contract {

  private String name;
  private List<Integer> monthlyPrices;

  public Contract(String name, List<Integer> monthlyPrices) {
    this.name = name;
    this.monthlyPrices = monthlyPrices;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getMonthlyPrices() {
    return monthlyPrices;
  }
}
