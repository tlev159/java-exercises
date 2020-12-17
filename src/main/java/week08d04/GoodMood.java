package week08d04;

public class GoodMood implements CanMark{

  int GOOD_MOOD = 5;

  @Override
  public int giveMark() {
    return GOOD_MOOD;
  }
}
