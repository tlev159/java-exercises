package algorithmscount.bankaccounts;

import classstructureintegrate.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccountConditionCounter {



  public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int greaterThan) {
    int accountNumber = 0;
    for (BankAccount bankAccount: bankAccounts) {
      if (bankAccount.getBalance() > greaterThan) {
        accountNumber++;
      }
    }
    return accountNumber;
  }

}
