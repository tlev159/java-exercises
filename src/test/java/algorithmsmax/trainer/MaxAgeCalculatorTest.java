package algorithmsmax.trainer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAgeCalculatorTest {

  List<Trainer> t = Arrays.asList(
          new Trainer("Jack", 30),
          new Trainer("Joe", 62),
          new Trainer("Paul", 50),
          new Trainer("Andy", 59)
  );

  @Test
  public void maxAgeCalculatorTest() {
    MaxAgeCalculator maxAge = new MaxAgeCalculator();

    assertEquals(62, maxAge.trainerWithMaxAge(t).getAge());
  }

}
