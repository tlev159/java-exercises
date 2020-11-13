package classstructureintegrate;

public class BankAccount {

  private String accountNumber;
  private String owner;
  private int balance;

  public BankAccount(String accountNumber, String owner, int balance) {
    this.accountNumber = accountNumber;
    this.owner = owner;
    this.balance = balance;
  }

  public void deposit(int amount) {
    this.balance += amount;
  }

  public void withdraw(int amount) {
    this.balance -= amount;
  }

  public void transfer(BankAccount to, int amount) {
    withdraw(amount);
    to.deposit(amount);
  }

  public String getInfo() {
    return getOwner() + " (" + getAccountNumber() + "): " + getBalance() + " Ft";
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getOwner() {
    return owner;
  }

  public int getBalance() {
    return balance;
  }
}
