package exceptions.polinom;

public class Polynomial {

  private double[] coefficients;
//  private String[] polinom;

  public Polynomial(double[] coefficients) {
    if (coefficients == null) {
      throw new NullPointerException("coefficients is null");
    }
    this.coefficients = coefficients;
  }

  public Polynomial(String[] polinom) {
    if (polinom == null) {
      throw new NullPointerException("coefficientStrs is null");
    }
    if (isParesableString(polinom)) {
      double[] poli = new double[polinom.length];
      for (int i = 0; i < polinom.length; i++) {
        poli[i] = Integer.parseInt(polinom[i]);
      }
      this.coefficients = poli;
    }
  }

  private boolean isParesableString(String[] str) {
    try {

      for (String s:str) {
        int c = Integer.parseInt(s);
      }
      return true;
    } catch (IllegalArgumentException iae) {
      throw new IllegalArgumentException("Illegal coefficients, not a number", iae);
    }
  }

  public double evaluate(double x) {
    double n = coefficients.length - 1;
    double result = 0.0;
    for (double d:coefficients) {
      result += d * Math.pow(x, n);
      n--;
    }
    return result;
  }

  public double[] getCoefficients() {
    return coefficients;
  }


}
