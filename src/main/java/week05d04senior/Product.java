package week05d04senior;

public class Product {

  private long price;
  private String currency;
//  private List<Currency> currencies = new ArrayList<>();


//  public Product(long price, String curr) {
//    this.price = price;
//    this.currency = curr;
//  }

//  public double convertCurrency(String cur) {
//    double cR = Currency.valueOf(cur).getChangingRate();
//    return price * cR;
//  }
//
//  public boolean isEmpty(String str) {
//    return (str == null || "".equals(str));
//  }
//
//  public static void main(String[] args) {
//    Product product = new Product(150, "HUF");
//    System.out.println(Math.round(product.convertCurrency("USD")*100.0)/100.0);
//  }

  public Product(long price, String currency) {
    if (currency.equals("HUF") || currency.equals("USD")) {
      this.price = price;
      this.currency = currency;
    } else {
      throw new IllegalArgumentException("Currency must be 'HUF' or 'USD'!");
    }
  }

  public double convertPrice(String currency) {
    return CurrencyType.valueOf(currency).getValue() * price;
  }
}
