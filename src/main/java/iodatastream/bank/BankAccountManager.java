package iodatastream.bank;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

  public void saveAccount(BankAccount bankAccount, Path path) {
    String fileName = path.toString() + "/" + bankAccount.getAccountNumber() + ".dat";
    Path file = Path.of(fileName);
    try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
      outputStream.writeUTF(bankAccount.getAccountNumber());
      outputStream.writeUTF(bankAccount.getOwner());
      outputStream.writeDouble(bankAccount.getBalance());
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not write file!", ioe);
    }
  }

  public BankAccount loadAccount(InputStream is) {
    try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(is))) {
      String ownername = inputStream.readUTF();
      String accountNr = inputStream.readUTF();
      double saldo = inputStream.readDouble();
      return new BankAccount(ownername, accountNr, saldo);
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }
}
