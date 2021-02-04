package week14d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContractCreator {

  private Contract template;

  public ContractCreator(String client, List<Integer> monthlyPrices) {
    this.template = new Contract(client, monthlyPrices);
  }

  public Contract createContract(String client) {
    return new Contract(client, new ArrayList<>(template.getMonthlyPrices()));
  }

  public Contract getTemplate() {
    return template;
  }

  public static void main(String[] args) {

    ContractCreator cc = new ContractCreator("John Doe", List.of(1,2,3,4,5,6,7,8,9,10,11,12));

    Contract john = cc.createContract("Jane Doe");
    john.getMonthlyPrices().set(1, 13);

    System.out.println(john.getMonthlyPrices());
    System.out.println(cc.getTemplate().getMonthlyPrices());
  }
}
