package abstractclass.gamecharacter;

public class Point {

  private long x;
  private long y;

  public Point(long x, long y) {
    this.x = x;
    this.y = y;
  }

  public long distance(Point point) {
    double dX = point.getX() - this.x;
    double dY = point.getY() - this.y;
    long dist = (long) (Math.sqrt(dX * dX + dY * dY));
    return dist;
  }

  public long getX() {
    return x;
  }

  public long getY() {
    return y;
  }
}
