package attributes.book;

public class BookMain {

  public static void main(String[] args) {

    Book book = new Book("Java-ban felkelt a nap...");
    Book book2 = new Book("Ez a dogol a dolgok színe-Java...");

    System.out.println(book.getTitle());
    book2.setTitle("..és megis rozoga Mozoga");

    System.out.println(book2.getTitle());
  }

}
