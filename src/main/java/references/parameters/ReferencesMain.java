package references.parameters;

public class ReferencesMain {

  public static void main(String[] args) {

    Person person1 = new Person("1 John Doe", 1995);
    Person person2 = new Person("2 Jack Doe", 1998);

    person1 = new Person("3 John Dagobert", 1999);
    person2 = person1;

    person2.setName("4 Jack Dagobert");

    System.out.println("Person1: " + person1.getName() + ", " + person1.getAge());
    System.out.println("Person2: " + person2.getName() + ", " + person2.getAge());

    int a;
    int b;
    a = 24;
    b = a;
    b++;
    System.out.println("a: " + a);
    System.out.println("b: " + b);

    person1 = new Person("5 Tobias Steinmeyer", 2000);

    System.out.println("Person1: " + person1.getName() + ", " + person1.getAge());
    System.out.println("Person2: " + person2.getName() + ", " + person2.getAge());

  }
}
