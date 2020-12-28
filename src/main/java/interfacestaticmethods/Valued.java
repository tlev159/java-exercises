package interfacestaticmethods;

import java.util.List;

public interface Valued {

  double getValue();

//  public static double sum(List<Valued> valueds) {
  public static double totalValue(List<Valued> valueds) {
    double sum = 0;
    for (Valued v:valueds) {
      sum+= v.getValue();
    }
    return sum;
  }
}
