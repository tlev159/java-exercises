package algorithmssum.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionSumCalculator {

//  List<Transaction> transactions = new ArrayList<>();

  public int sumAmountOfCreditEntries(List<Transaction> transactions) {
    int sumOfAmount = 0;
    for (Transaction transaction : transactions) {
      if (transaction.isCredit()) {
        sumOfAmount += transaction.getAmount();
      }
    }
    return sumOfAmount;
  }
}
