package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> books = new ArrayList<>();

  public void add(Book book) {
    if (book == null || book.getAuthor().isBlank() || book.getTitle().isBlank()) {
      throw new IllegalArgumentException("Book can not empty!");
    }
    boolean ifContains = false;
    for (Book b : books) {
      if (b.equals(book)) {
        ifContains = true;
      }
    }
    if (!ifContains) {
      books.add(book);
    }
  }

  public void saveBooks(Path path) {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path)))) {
      for (Book book : books) {
        writer.write(book.getAuthor() + ": " + book.getTitle() + "\n");
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not write file!", ioe);
    }
  }

  public List<Book> loadBooks(Path path) {
    List<Book> newBooksFromFile = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(path)))){
      String line;
      while ((line = reader.readLine()) != null) {
        String[] bookExempl = line.trim().split(":");
        newBooksFromFile.add(new Book(bookExempl[0], bookExempl[1].trim()));
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Can not read file!", ioe);
    }
    return newBooksFromFile;
  }

  public List<Book> getBooks() {
    return books;
  }
}
