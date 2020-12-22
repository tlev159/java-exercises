package inheritancemethods.bankaccount;

public class DebitAccount {

  private String accountNumber;
  private long balance;

  private final double COST = 3.0;
  private final long MIN_COST = 200;

  public DebitAccount(String accountNumber, long balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public final long costOfTransaction(long amount) {
    long costOfTransa = (long) (amount * COST / 100L);
    if (costOfTransa <= 200) {
      costOfTransa = 200L;
      return 200L;
    } else {
      return costOfTransa;
    }
  }

  public boolean transaction(long amount) {
    if (balance - (amount + costOfTransaction(amount)) < 0) {
      return false;
    } else {
      balance -= (amount + costOfTransaction(amount));
      return true;
    }
  }

  public void balanceToZero() {
    balance = 0L;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public long getBalance() {
    return balance;
  }

  public double getCOST() {
    return COST;
  }

  public long getMIN_COST() {
    return MIN_COST;
  }
}
