package week08d04;

public class BadMood implements CanMark{

  int BAD_MOOD = 3;

  @Override
  public int giveMark() {
    return BAD_MOOD;
  }
}
