package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

  public boolean containsBalanceGreaterThan(List<BankAccount> bankAccounts, int amount) {
    for (BankAccount account: bankAccounts) {
      if (account.getBalance() > amount) {
        return true;
      }
    }
    return false;
  }

}
