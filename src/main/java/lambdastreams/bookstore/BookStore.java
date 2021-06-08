package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public Integer getNumberOfBooks() {
        return books.stream().reduce(0, (a, b) -> a + b.getNumber(), (a, b) -> a + b);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().sorted(Comparator.comparing(Book::getYearOfPublish).reversed()).findFirst();
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (a, b) -> a + b.getPrice() * b.getNumber(), (a, b) -> a + b);
    }

    public List<Book> getByYearOfPublish(int year) {
//        return books.stream().filter(b -> b.getYearOfPublish() == year).collect(Collectors.toList());
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }

    public List<Book> getBooks() {
        return books;
    }
}
