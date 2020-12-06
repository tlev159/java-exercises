package methodpass.troopers;

public class Trooper {

  private String name;
  private Position position;

  public Trooper(String name) {
    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Name must not be empty.");
    }
    this.name = name;
    if (position == null) {
      changePosition(new Position(0, 0));
    }
  }

  public void changePosition(Position target) {
    if (target == null) {
      throw new IllegalArgumentException("Coordinates must not be null.");
    }
    position = target;
  }

  public double distanceFrom(Position target){
    if (target == null) {
      throw new IllegalArgumentException("Coordinates must not be null.");
    }
    return position.distanceFrom(target);
  }

  public String getName() {
    return name;
  }

  public Position getPosition() {
    return position;
  }
}
