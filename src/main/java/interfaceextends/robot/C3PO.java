package interfaceextends.robot;

import methodpass.troopers.Position;

import java.util.List;

public class C3PO implements MoveableRobot{

  private Point position;
  private int angle;

  public C3PO(Point initialPoint) {
    new Point(initialPoint.getX(), initialPoint.getY(), initialPoint.getZ());
  }

  public void moveTo(Point position) {
    walkTo(position);
  }
  @Override
  public void fastMoveTo(Point position) {
    walkTo(position);
  }

  public void rotate(int angle) {
    this.angle += angle;
  }

  private void walkTo(Point position) {
    this.position = position;
    path.add(position);
  }

  @Override
  public List<Point> getPath() {
    return path;
  }

  public Point getPosition() {
    return position;
  }

  public int getAngle() {
    return angle;
  }
}
