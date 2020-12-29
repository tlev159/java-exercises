package week09d03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SantaClausTest {

  @Test
      public void testSantaClaus() {

    List<Person> personList = new ArrayList<>(Arrays.asList(
      new Person("John Doe", 12),
      new Person("Jane Doe", 13),
      new Person("Johnny Doe", 14),
      new Person("Jacky Doe", 15),
      new Person("Jim Doe", 16),
      new Person("Jamie Doe", 10),
      new Person("Jonatan Doe", 4)
    ));

    SantaClaus sc = new SantaClaus(personList);

    sc.getThroughChimneys();

    for (Person p:personList) {
      System.out.println(p.toString());
    }
  }

}
