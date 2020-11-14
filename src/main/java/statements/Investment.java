package statements;

public class Investment {

  private double cost;
  private int fund;
  private int interestRate;
  boolean active = true;

  public Investment(int fund, int interestRate) {
    this.fund = fund;
    this.interestRate = interestRate;
  }

  public int getFund() {
    return fund;
  }

  public double getYield(int days) {
    double yield = fund * (interestRate / 100.0) * days / 365.0;
    return yield;
//      return interestRate / 100.0;
  }

  public double close(int days) {
    if (active == true) {
      active = false;
      double toPaydSum = fund + getYield(days);
      cost = toPaydSum * 0.003;
      return toPaydSum - cost;
    } else {
      return 0;
    }
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public void setFund(int fund) {
    this.fund = fund;
  }

  public void setInterestRate(int interestRate) {
    this.interestRate = interestRate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
