package week12d02;

public class FenceStat {

  private int perfect;
  private int noFence;
  private int needUpgrade;

  public int getPerfect() {
    return perfect;
  }

  public void setPerfect() {
    this.perfect++;
  }

  public int getNoFence() {
    return noFence;
  }

  public void setNoFence() {
    this.noFence++;
  }

  public int getNeedUpgrade() {
    return needUpgrade;
  }

  public void setNeedUpgrade() {
    this.needUpgrade++;
  }
}
