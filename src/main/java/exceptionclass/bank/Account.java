package exceptionclass.bank;

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
      throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
    }
    if ((balance - sum) < 0) {
      throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
    }
    balance -= sum;
    return balance;
  }

  public double deposit(double sum) {
    if (sum <= 0) {
      throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
    }
    balance += sum;
    return balance;
  }

  public void setMaxSubtract(double maxSubtract) {
    if (maxSubtract < 0) {
      throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
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
