package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

  public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salesperson) {
    int maxSalesAmount = 0;
    Salesperson pwmsa = new Salesperson("", 0, 0);
    for (Salesperson sp : salesperson) {
      if (maxSalesAmount < sp.getAmount()) {
        maxSalesAmount = sp.getAmount();
        pwmsa = sp;
      }
    }
    return pwmsa;
  }
}
