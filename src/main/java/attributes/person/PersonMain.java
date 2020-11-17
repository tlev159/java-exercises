package attributes.person;

import introdate.Performance;

public class PersonMain {

  public static void main(String[] args) {

    Person person1 = new Person("John Doe", "123-456-78");
    person1.moveTo(new Address("Hungary", "Szeged", "Bem u. 3.", "6727"));

    System.out.println(person1.personToString());
    System.out.println("címe: " + person1.getAddress());

    person1.moveTo(new Address("Ausztria", "Wien", "Mariahilfer Str. 3.", "11254"));

    System.out.println(person1.personToString());
    System.out.println("Új címe: " + person1.getAddress());

  }
}
