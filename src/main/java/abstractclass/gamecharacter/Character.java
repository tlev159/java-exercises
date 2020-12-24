package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

  private Point position;
  private int hitPoint;
  private Random random;

  public Character(Point position, Random random) {
    this.position = position;
    this.hitPoint = 100;
    this.random = random;
  }

  public boolean isAlive() {
    if (hitPoint > 0) {
      return true;
    } else {
      return false;
    }
  }

  protected int getActualPrimaryDamage() {
    return random.nextInt(10) + 1;
  }

  private int getActualDefence() {
    return random.nextInt(5);
  }

  protected void hit(Character enemy, int damage) {
    if (getActualDefence() < damage) {
//      decreaseHitPoint(damage);
      enemy.hitPoint -= damage;
    }
  }

  public void primaryAttack(Character enemy) {
    hit(enemy, getActualPrimaryDamage());
  }

  private void decreaseHitPoint(int diff) {
    hitPoint -= diff;
  }

  public abstract void secondaryAttack(Character enemy);

  public Point getPosition() {
    return position;
  }

  public int getHitPoint() {
    return hitPoint;
  }

  public Random getRandom() {
    return random;
  }
}
