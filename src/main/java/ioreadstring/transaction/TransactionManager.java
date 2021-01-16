package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

  private static final String SEPARATOR = ";";

  private List<BankAccount> accountList = new ArrayList<>();


  public void uploadListFromFile(String path) {
    try {
      List<String> accounts = Files.readAllLines(Path.of(path));
      addAccountsToList(accounts);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Cannot read file" , ioe);
    }
  }

  private boolean addAccountsToList(List<String> accounts) {
    for (String str:accounts) {
      String[] acc = str.split(SEPARATOR);
      accountList.add(new BankAccount(acc[0], acc[1], Integer.parseInt(acc[2])));
    }
      return true;
  }

  public void makeTransactions(String path) {
    try {
      List<String> transactionList = Files.readAllLines(Path.of(path));
      transactions(transactionList);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Invalid datas!", ioe);
    }
  }

  private void transactions(List<String> transacts) {
    for (String str:transacts) {
      String[] transactionInfo = str.split(SEPARATOR);
      findAccountAndMakeTransaction(transactionInfo);
    }
  }

  public void findAccountAndMakeTransaction(String[] tI) {
    for (BankAccount ba:accountList) {
      if (ba.getAccountNumber().equals(tI[0])) {
        ba.setBalance(Integer.parseInt(tI[1]));
      }
    }
  }

  public List<BankAccount> getAccountList() {
    return accountList;
  }
}
