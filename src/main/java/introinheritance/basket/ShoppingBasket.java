package introinheritance.basket;

public class ShoppingBasket {

  private Basket basket = new Basket();

  public void addItem(Item item) {
    basket.addItem(item);
  }

  public void removeItem(String barcode) {
    basket.removeItem(barcode);
  }

  public double sumNettoPrice() {
    double sumNetto = 0.0;
    for (int i = 0; i < basket.getItems().size(); i++) {
      sumNetto += basket.getItems().get(i).getNettoPrice();
    }
    return sumNetto;
  }

  public double sumTaxValue() {
    double sumTax = 0.0;
    for (int i = 0; i < basket.getItems().size(); i++) {
      sumTax += basket.getItems().get(i).getTaxAmount();
    }
    return sumTax;

  }

  public double sumBruttoPrice() {
    double sumBrutto = 0.0;
    for (int i = 0; i < basket.getItems().size(); i++) {
      sumBrutto += basket.getItems().get(i).getNettoPrice() + basket.getItems().get(i).getTaxAmount();
    }
    return sumBrutto;

  }

  public void checkout() {
    basket.clearBasket();
  }

  public void removeMostExpensiveItem() {

  }


}
