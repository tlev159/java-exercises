package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

  public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersonList) {
    int different = 0;
    int d = 0;
    Salesperson sp = new Salesperson("", 0,0);
    for (Salesperson salesperson: salespersonList) {
      d = salesperson.getTarget() - salesperson.getAmount();
      if (d < different) {
        sp = salesperson;
        different = d;
      }
    }
    return sp;
  }
}
