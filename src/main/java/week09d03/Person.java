package week09d03;

import java.util.Random;

public class Person {

  private String name;
  private int age;
  private Present present;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setPresent() {
    if (age <= 14) {
      Random rnd = new Random();
      int p = rnd.nextInt(4);
      switch (p) {
        case 0:
          present = Present.TOY;
          break;
        case 1:
          present = Present.ELECTRONIC;
          break;
        case 2:
          present = Present.HOUSEKEEPING;
          break;
        case 3:
          present = Present.DECORATION;
      }
    }
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Present getPresent() {
    return present;
  }

  @Override
  public String toString() {
    return name + " (" + age + "): "+ present;
  }
}
