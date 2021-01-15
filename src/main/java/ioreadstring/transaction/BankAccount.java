package ioreadstring.transaction;

public class BankAccount {

  private static final String SEPARATOR = ";";

  private String name;
  private String accountNumber;
  private int balance;

  public BankAccount(String name, String accountNumber, int balance) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public void setBalance(int sum) {
    balance += sum;
  }

  public String getName() {
    return name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public int getBalance() {
    return balance;
  }
}
