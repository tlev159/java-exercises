package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

  public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
    for (BankAccount ba:accounts) {
      for (Transaction tr:transactions) {
        if (ba.getAccountNumber().equals(tr.getAccountNumber())) {
          if (tr.isCredit()) {
            ba.deposit(tr.getAmount());
          } else {
            ba.withdraw(tr.getAmount());
          }
        }
      }
    }
  }

}
