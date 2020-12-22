package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{

  private long overdraftLimit;

  public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
    super(accountNumber, balance);
    this.overdraftLimit = overdraftLimit;
  }

  public boolean transaction(long amount) {
    long toDivSum = amount + super.costOfTransaction(amount);
    if ((getBalance() + overdraftLimit) - toDivSum < 0) {
      return false;
    } else if (getBalance() < toDivSum && (getBalance() + overdraftLimit) > toDivSum) {
      toDivSum -= getBalance();
      super.balanceToZero();
      overdraftLimit -= toDivSum;
      return true;
    } else {
      super.transaction(amount);
      return true;
    }
  }

  public long getOverdraftLimit() {
    return overdraftLimit;
  }
}
