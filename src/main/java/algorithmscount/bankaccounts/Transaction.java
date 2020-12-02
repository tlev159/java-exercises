package algorithmscount.bankaccounts;

public class Transaction {

  private String AccountNumber;
  private TransactionType transactionType;
  private int amount;

  public Transaction(String accountNumber, TransactionType transactionType, int amount) {
    AccountNumber = accountNumber;
    this.transactionType = transactionType;
    this.amount = amount;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public int getAmount() {
    return amount;
  }

  public boolean isCredit() {
    return transactionType == TransactionType.CREDIT;
  }

  public boolean isDebit() {
    return transactionType == TransactionType.DEBIT;
  }
}
