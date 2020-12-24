package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character{

  private int numberOfArrow;

  public Archer(Point position, Random random) {
    super(position, random);
    this.numberOfArrow = 100;
  }

  public int getNumberOfArrow() {
    return numberOfArrow;
  }

  private int getActualSecondaryDamage() {
    int rndDecrease = new Random().nextInt(5) + 1;
    return rndDecrease;
  }

  private void shootingAnArrow(Character enemy) {
    numberOfArrow--;
    int rndDecrease = getActualSecondaryDamage();
//    System.out.println("rndDecrease: " + rndDecrease + ", hitPoint: " + getHitPoint());
    hit(enemy, rndDecrease);
  }

  @Override
  public void secondaryAttack(Character enemy) {
    shootingAnArrow(enemy);
  }
}
