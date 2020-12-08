package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

  private List<Pub> pubs = new ArrayList<>();

  public ListOfGoodPubs(List<Pub> goodpubs) {
    this.pubs = goodpubs;
  }

  public Pub findTheBest() {
    Pub best = this.pubs.get(0);
    for (Pub pub:this.pubs) {
      if (pub.getOpenFrom().isEarlier(best.getOpenFrom())) { ;
        best = pub;
      }
    }
    return best;
  }
}
