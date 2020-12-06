package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

  private List<Trooper> troopers = new ArrayList<>();

  public List<Trooper> getTroopers() {
    return troopers;
  }

  public void  addTrooper(Trooper trooper) {
    troopers.add(trooper);
  }

  public void moveTrooperByName(String name, Position target) {
    moveTrooper(findTrooperByName(name), target);
  }

  public void moveClosestTrooper(Position target) {
    moveTrooper(findClosestTrooper(target), target);
  }

  private Trooper findTrooperByName(String name) {
    Trooper t = new Trooper(" ");
    for (Trooper tr:troopers) {

      if (tr.getName().equals(name) || name.equals(tr.getName())) {
        t = tr;
      }
    }
    return t;
  }

  private Trooper findClosestTrooper(Position target) {
    Trooper t = new Trooper("proba");
    double maxDistance = 0.0;
    double minDistance = 0.0;
    for (Trooper tr:getTroopers()) {
      if (tr.distanceFrom(target) > maxDistance) {
        maxDistance = tr.distanceFrom(target);
      }
    }
    minDistance = maxDistance;
    for (Trooper tr:getTroopers()) {
      if (tr.distanceFrom(target) < minDistance) {
        minDistance = tr.distanceFrom(target);
        t = tr;
      }
    }
    return t;
  }

  private void moveTrooper(Trooper trooper, Position target) {
    trooper.changePosition(target);
  }
}
