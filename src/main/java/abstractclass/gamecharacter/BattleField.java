package abstractclass.gamecharacter;

public class BattleField {

  private int round;

  private boolean oneHit(Character attacker, Character defender) {
    attacker.primaryAttack(defender);
    attacker.secondaryAttack(defender);
    if (attacker.isAlive() && defender.isAlive()) {
      return true;
    } else {
      return false;
    }
  }

  public Character fight(Character one, Character other) {
    Character isAliveCharacter;
    while (one.isAlive() && other.isAlive()) {
      oneHit(one, other);
      oneHit(other, one);
      round++;
    }
    if (one.isAlive()) {
      isAliveCharacter = one;
    } else {
      isAliveCharacter = other;
    }
    return isAliveCharacter;
  }

  public int getRound() {
    return round;
  }
}
