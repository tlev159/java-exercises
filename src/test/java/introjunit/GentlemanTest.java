package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GentlemanTest {

  @Test
  public void testSayHello() {
    String answer = "John Doe";
    String gentleman = new Gentleman().sayHello(answer);
    assertEquals("Hello John Doe", gentleman);


    String answer1 = null;
    String gentleman2 = new Gentleman().sayHello(answer1);
    assertEquals("Hello Anonymus", gentleman2);
  }
}
