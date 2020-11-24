package week05d02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChangeLetterTest {

  @Test
  public void testChangeLetter() {
    ChangeLetter cL = new ChangeLetter();
    String changeLetterTest1 = "arvizturotukorfurogep";
    assertEquals("*rv*zt*r*t*k*rf*r*g*p", cL.changeVowels(changeLetterTest1));
  }

  @Test
  public void testChangeLetterTestCaseSensitive() {
    ChangeLetter cL = new ChangeLetter();
    String changeLetterTest2 = "Halado holdado Elment Uberrel";
    assertEquals("H*l*d* h*ld*d* *lm*nt *b*rr*l", cL.changeVowels(changeLetterTest2));
  }
  @Test
  public void testChangeLetter2() {
    ChangeLetter cL = new ChangeLetter();
    String changeLetterTest1 = "arvizturotukorfurogep";
    assertEquals("*rv*zt*r*t*k*rf*r*g*p", cL.changeVowels2(changeLetterTest1));
  }

  @Test
  public void testChangeLetterTestCaseSensitive2() {
    ChangeLetter cL = new ChangeLetter();
    String changeLetterTest2 = "Halado holdado Elment Uberrel";
    assertEquals("H*l*d* h*ld*d* *lm*nt *b*rr*l", cL.changeVowels2(changeLetterTest2));
  }
}
