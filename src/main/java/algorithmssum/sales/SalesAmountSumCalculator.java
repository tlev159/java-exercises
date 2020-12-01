package algorithmssum.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {

  public int sumSalesAmount(List<Salesperson> salespersons) {
    int sumAmounts = 0;
    for (Salesperson persons: salespersons) {
      sumAmounts += persons.getAmount();
    }
    return sumAmounts;
  }


}
