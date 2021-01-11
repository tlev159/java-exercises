package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;
import exceptionclass.bank.InvalidBankOperationException;

public class Account {

  private String accountNumber;
  private double balance;
  private double maxSubtract;

  public Account(String accountNumber, double balance) {
    if (accountNumber == null || "".equals(accountNumber)) {
      throw new IllegalArgumentException("Invalid account number!");
    }
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.maxSubtract = 100_000;
  }

  public double subtract(double sum) {
    if (sum <= 0) {
      throw new InvalidAmountBankOperationException("Invalid amount");
    }
    if ((balance - sum) < 0) {
      throw new LowBalanceBankOperationException("Low balance");
    }
    balance -= sum;
    return balance;
  }

  public double deposit(double sum) {
    if (sum <= 0) {
      throw new InvalidAmountBankOperationException("Invalid amount");
    }
    balance += sum;
    return balance;
  }

  public void setMaxSubtract(double maxSubtract) {
    if (maxSubtract < 0) {
      throw new InvalidAmountBankOperationException("Invalid amount");
    }
    this.maxSubtract = maxSubtract;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public double getMaxSubtract() {
    return maxSubtract;
  }
}
