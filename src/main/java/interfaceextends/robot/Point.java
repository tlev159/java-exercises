package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class Point {

  private final long x;
  private final long y;
  private final long z;
  private List<Point> path = new ArrayList<>();

  public Point(long x, long y, long z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Point(long x, long y) {
    this.x = x;
    this.y = y;
    this.z = 0;
  }

  public long getX() {
    return x;
  }

  public long getY() {
    return y;
  }

  public long getZ() {
    return z;
  }
}
