package week09d03;

import java.util.List;

public class SantaClaus {

  private List<Person> people;

  public SantaClaus(List<Person> people) {
    this.people = people;
  }

  public void getThroughChimneys() {
    for (Person p: people) {
      p.setPresent();
    }
  }

  public List<Person> getPeople() {
    return people;
  }

}
