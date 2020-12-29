package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

  public static final long ALTITUDE = 5;
  private Point position;
  private int angle;
  private List<Point> path = new ArrayList<>();

  public AstroBoy(Point position) {
    this.position = position;
  }

  public void walkTo(Point position) {
    this.position = position;
    path.add(this.position);
  }

  public void flyTo(Point position) {
    this.position = new Point(position.getX(), position.getY(), ALTITUDE);
    path.add(this.position);
  }

  @Override
  public void liftTo(long altitude) {
    this.position = new Point(position.getX(), position.getY(), altitude);
    path.add(this.position);
  }

  @Override
  public void moveTo(Point position) {
    this.position = position;
    path.add(this.position);
  }

  @Override
  public void fastMoveTo(Point position) {
    liftTo(ALTITUDE);
    flyTo(position);
    liftTo(position.getZ());
  }

  @Override
  public void rotate(int angle) {
    this.angle += angle;
  }

  public Point getPosition() {
    return position;
  }

  public int getAngle() {
    return angle;
  }

  @Override
  public List<Point> getPath() {
    return path;
  }

  public long getAltitude() {
    return position.getZ();
  }
}
