package exceptionclass.bank2;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private List<Account> accounts = new ArrayList<>();

  public Bank(List<Account> accounts) {
    if (accounts == null) {
      throw new IllegalArgumentException("Empty account list!");
    }
    this.accounts = accounts;
  }

  public void payment(String account, double amount) {
    int acc = 0;
    for (Account a:accounts) {
      if (a.getAccountNumber().equals(account)) {
        a.subtract(amount);
        acc++;
      }
    }
    if (acc < 1) {
      throw new InvalidAccountNumberBankOperationException("Invalid account number");
    }
  }

  public void deposit(String account, double amount) {
    int acc = 0;
    for (Account a:accounts) {
      if (a.getAccountNumber().equals(account)) {
        a.deposit(amount);
        acc++;
      }
    }
    if (acc < 1) {
      throw new InvalidAccountNumberBankOperationException("Invalid account number");
    }
  }

  public List<Account> getAccounts() {
    return accounts;
  }
}
