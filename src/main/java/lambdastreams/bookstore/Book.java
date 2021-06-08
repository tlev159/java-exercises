package lambdastreams.bookstore;

import java.time.LocalDate;

public class Book {

    private String name;
    private int yearOfPublish;
    private int price;
    private int number;

    public Book(String name, int yearOfPublish, int price, int number) {
        this.name = name;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
