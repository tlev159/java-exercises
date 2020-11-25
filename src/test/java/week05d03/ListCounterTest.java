package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

  @Test
  public void testListCounter() {
    ListCounter listCounter = new ListCounter();

    List<String> testList = new ArrayList<>(Arrays.asList("Alma", "balma", "ablak", "körte", "barack", "ajtó", "Aladár", "Csiga"));

    assertEquals(4, listCounter.counter(testList));
  }
}
