package introjunit;

import introjuit.Gentleman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GentlemanTest {

  @Test
  public void testSayHello() {
    Gentleman gentleman = new Gentleman();
    String answer = gentleman.sayHello("John Doe");
    assertEquals("Hello John Doe", answer);

  }

}
