package math.game;

public class Point {

  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double distance(Point other) {
    /*
    A(x1, y1); B(x2, y2)
    distabce(A,B) = sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2))
     */
    double distance = Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    return distance;
  }
}
