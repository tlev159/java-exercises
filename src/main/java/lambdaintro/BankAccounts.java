package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

  private List<BankAccount> bankAccounts;

  public BankAccounts(List<BankAccount> bankAccounts) {
    this.bankAccounts = bankAccounts;
  }

  public List<BankAccount> listBankAccountsByAccountNumber() {
    List<BankAccount> sortedByAccountNumber = new ArrayList<>(bankAccounts);
    sortedByAccountNumber.sort(Comparator.naturalOrder());
    return sortedByAccountNumber;
  }

  public List<BankAccount> listBankAccountsByBalance() {
    List<BankAccount> sorted = new ArrayList<>(bankAccounts);
    sorted.sort(Comparator.comparing(acc -> Math.abs(acc.getBalance())));
    return sorted;
  }

  public List<BankAccount> listBankAccountsByBalanceDesc() {
    List<BankAccount> sorted = new ArrayList<>(bankAccounts);
    sorted.sort(Comparator.comparing(BankAccount::getBalance).reversed());
    return sorted;
  }

  public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
    List<BankAccount> sorted = new ArrayList<>(bankAccounts);
    sorted.sort(Comparator.comparing(BankAccount::getNameOfOwner,
            Comparator.nullsFirst(Collator.getInstance(new Locale("hu", "HU"))))
            .thenComparing(BankAccount::getAccountNumber));
    return sorted;
  }

  public List<BankAccount> getBankAccounts() {
    return bankAccounts;
  }
}
