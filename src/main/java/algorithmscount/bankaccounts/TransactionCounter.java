package algorithmscount.bankaccounts;

import java.util.ArrayList;
import java.util.List;

public class TransactionCounter {

  List<Transaction> transactions = new ArrayList<>();

  public int countEntryLessThan(List<Transaction> transactions, int borderNumber) {
    int count = 0;
    for (Transaction ta : transactions) {
      if (ta.getAmount() < borderNumber) {
        count++;
      }
    }
    return count;
  }
}
