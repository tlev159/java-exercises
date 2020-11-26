package week05d04;

import java.time.LocalDate;

public class Product {

  private String name;
  private LocalDate date;

  public Product(String name, int year, int month, int day) {
    this.name = name;
    this.date = LocalDate.of(year, month, day);
  }

  public String getName() {
    return name;
  }

  public LocalDate getDate() {
    return date;
  }
}
