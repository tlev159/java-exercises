package methodparam.measuring;

public class Measurement {

  private double[] values;

  public Measurement(double[] values) {
    if (values == null) {
      throw new IllegalArgumentException("Values must be not empty.");
    }
    this.values = values;
  }

  public int findFirstIndexInLimit(int lower, int upper) {
    int i = 0;
    for (double v:values) {
       if (lower < v && v < upper) {
         return i;
       }
       i++;
    }
    return -1;
  }

  public double minimum() {
    double min = values[0];
    for (double v:values) {
      if (v < min) {
        min = v;
      }
    }
    return min;
  }

  public double maximum() {
    double max = values[0];
    for (double v:values) {
      if (max < v) {
        max = v;
      }
    }
    return max;
  }

  public ExtremValues minmax() {
    double min = minimum();
    double max = maximum();
    return new ExtremValues(min, max);
  }
}
