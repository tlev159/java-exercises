package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

  public void saveTransactions(Path path, List<Transaction> transactions) {
    try (ZipOutputStream os = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
      for (Transaction transaction : transactions) {
        os.putNextEntry(new ZipEntry(transaction.getId() + ".dat"));
        os.write((transaction.getTime() + "\n").getBytes());
        os.write((transaction.getAccount() + "\n").getBytes());
        os.write((transaction.getAmount() + "\n").getBytes());
      }

    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }


}
