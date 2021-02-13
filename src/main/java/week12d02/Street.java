package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

  private List<Site> houses = new ArrayList<>();

  public void sellSite(Site site) {
    houses.add(site);
  }

  public int houseNumberOfTheLastSelldHouse() {
    int witchSide = houses.get(houses.size()- 1).getSide();
    int count = 0;
    for (Site site : houses) {
      if (site.getSide() == witchSide) {
        count++;
      }
    }
    if (witchSide == 0) {
      return 2 * count;
    } else {
      return 2 * count - 1;
    }
  }

  public FenceStat statistic() {
    FenceStat fc = new FenceStat();
    for (Site site : houses) {
      if (site.getFence().equals(Fence.PERFECT)) {
        fc.setPerfect();
      } else if (site.getFence().equals(Fence.NEED_UPGRADE)) {
        fc.setNeedUpgrade();
      } else if (site.getFence().equals(Fence.NO_FENCE)){
        fc.setNoFence();
      }
    }
    return fc;
  }
}
