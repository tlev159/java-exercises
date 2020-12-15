package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {

  private static long currentMinValue;
  private static long currentMaxValue;
  private static BigDecimal sumOfTrxs;
  private static long trNum;
  private static long trxValue;

  public BankTransaction(long trxValue) {
    if (trxValue < 1L || trxValue > 10_000_000L) {
      throw new IllegalArgumentException("Transaction must be in the gap!");
    }
    this.trxValue = trxValue;
    if (currentMinValue >= trxValue || currentMinValue == 0) {
      setCurrentMinValue(trxValue);
    }
    if (currentMaxValue <= trxValue || currentMaxValue == 0) {
      setCurrentMaxValue(trxValue);
    }
      this.sumOfTrxs = sumOfTrxs.add(BigDecimal.valueOf(trxValue));
    trNum++;
  }

  public static void initTheDay() {
      trxValue = 0L;
      setCurrentMaxValue(0L);
      setCurrentMinValue(0L);
      currentMaxValue = getCurrentMaxValue();
      currentMinValue = getCurrentMinValue();
      sumOfTrxs = BigDecimal.valueOf(0);
      trNum = 0;
  }

  public static BigDecimal averageOfTransaction() {
    return sumOfTrxs.divide(BigDecimal.valueOf(trNum));
  }


  public static long getCurrentMinValue() {
    return currentMinValue;
  }

  public static long getCurrentMaxValue() {
    return currentMaxValue;
  }

  public static BigDecimal getSumOfTrxs() {
    return sumOfTrxs;
  }

  public long getTrxValue() {
    return trxValue;
  }

  public static void setCurrentMinValue(long currentMinValue) {
    BankTransaction.currentMinValue = currentMinValue;
  }

  public static void setCurrentMaxValue(long currentMaxValue) {
    BankTransaction.currentMaxValue = currentMaxValue;
  }
}
