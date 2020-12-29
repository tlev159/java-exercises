package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public interface MoveableRobot {

  List<Point> path = new ArrayList<>();

  default void moveTo(Point position) {
    path.add(position);
  };
  default void fastMoveTo(Point position) {
    path.add(position);
  };
  void rotate(int angle);
  default List<Point> getPath() {
    return path;
  };
}
