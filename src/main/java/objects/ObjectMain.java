package objects;

public class ObjectMain {

  public static void main(String[] args) {

    new Book();

    System.out.println(new Book());

    Book emptyBook = null;
    System.out.println(emptyBook);

    System.out.println(emptyBook == null);

    Book book = new Book();
    System.out.println(book);

    book = null;
    System.out.println(book);

    book = new Book();

    Book anotherBook = new Book();

    System.out.println(book == anotherBook);

    anotherBook = book;
    System.out.println(anotherBook);
    System.out.println(anotherBook == book);

    System.out.println(anotherBook instanceof Book);

  }


}
