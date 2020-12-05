package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

  public Pendrive best(List<Pendrive> pendrives) {
    Pendrive bestPricePerCapacity = pendrives.get(0);
    for (int i = 0; i < pendrives.size() - 1; i++) {
      if (pendrives.get(i).comparePricePerCapacity(pendrives.get(i+1)) == -1) {
        bestPricePerCapacity = pendrives.get(i);
      }
    }
    return bestPricePerCapacity;
  }

  public Pendrive cheapest(List<Pendrive> pd) {
    Pendrive minPricePendrive = pd.get(0);
    for (int i = 1; i < pd.size();i++) {
      if (pd.get(i).cheaperThan(minPricePendrive)) {
        minPricePendrive = pd.get(i);
      }
    }
    return minPricePendrive;
  }

  public void risePriceWhereCapacity(List<Pendrive> pd, int percent, int capacity) {
    for (int i = 0; i < pd.size(); i++) {
      if (pd.get(i).getCapacity() == capacity) {
        pd.get(i).risePrice(percent);
      }
    }
  }

}
