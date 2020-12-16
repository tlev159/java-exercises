package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

  public static final List<Rate> ACTUAL_RATES = new ArrayList<>();

  private long balance;

  public CreditCard(long balance, Currency currency, List<Rate> upload) {
    ACTUAL_RATES.addAll(upload);
    this.balance = Math.round(balance * getConversionsFactor(currency));
  }

  public CreditCard(long balance) {
    this.balance = balance;
  }

  public boolean payment(long amount, Currency currency) {
    long value = Math.round(amount * getConversionsFactor(currency));
    if (value <= balance) {
      balance -= value;
      return true;
    }
    return false;
  }

  public boolean payment(long amount) {
    return payment(amount, Currency.HUF);
  }

  public double getConversionsFactor(Currency currency) {
    for (Rate r:ACTUAL_RATES) {
      if (r.getCurrency() == currency) {
        return r.getConversionFactor();
      }
    }
    return 1.0;
  }

  public long getBalance() {
    return balance;
  }
}
