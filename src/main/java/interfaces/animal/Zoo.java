package interfaces.animal;

import methodoverloading.pub.Pub;

import java.util.List;

public class Zoo {

  private List<Animal> animals;

  public Zoo(List<Animal> animals) {
    this.animals = animals;
  }

  public int getNumberOfAnimals() {
    return animals.size();
  }

  public int getNumberOfLegs() {
    int legs = 0;
    for (Animal a:animals) {
      legs+= a.getNumberOfLegs();
    }
    return legs;
  }
}
