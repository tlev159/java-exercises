package stringbasic.pets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vet {

  private List<Pet> pets = new ArrayList<>();

  public List<Pet> getPets() {
    return pets;
  }

  public void add(Pet newPet) {
    for (Pet animal: pets) {
      if (areEquals(animal, newPet)) {
        return;
      }
    }
    pets.add(newPet);
  }

  private boolean areEquals(Pet pet1, Pet newPet) {
    return pet1.getRegistrationNumber().equals(newPet.getRegistrationNumber());
  }
}
