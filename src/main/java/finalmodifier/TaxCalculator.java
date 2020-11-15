package finalmodifier;

public class TaxCalculator {

  public static final double TAX = 0.27;

  public double tax(double price) {
    return price * TAX;
  }

  public double priceWithTax(double price) {
    return price * (1 + TAX);
  }

  public static void main(String[] args) {
    TaxCalculator taxCalculator = new TaxCalculator();

    System.out.println(taxCalculator.tax(100));

    System.out.println(taxCalculator.priceWithTax(100));
  }
}
