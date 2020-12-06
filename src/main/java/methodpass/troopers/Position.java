package methodpass.troopers;

public class Position {

  private double posX;
  private double posY;

  public Position(double posX, double posY) {
    this.posX = posX;
    this.posY = posY;
  }

  public double distanceFrom(Position position) {
    double distX = this.posX - position.getPosX();
    double distY = this.posY - position.getPosY();
    return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
  }

  public double getPosX() {
    return posX;
  }

  public double getPosY() {
    return posY;
  }
}
