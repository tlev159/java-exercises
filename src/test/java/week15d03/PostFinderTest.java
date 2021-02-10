package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

  @Test
  void findPostsFor() {

    PostFinder pf = new PostFinder(Arrays.asList(
            new Post("Hello", LocalDate.of(2021, 01, 01), "Something", "me"),
            new Post("Hello", LocalDate.of(2021, 02, 01), "Today", "me"),
            new Post("Hello", LocalDate.of(2021, 02, 10), "Something", "you"),
            new Post("Hello", LocalDate.of(2020, 03, 01), "Something", "you"),
            new Post("Hello", LocalDate.of(2020, 04, 01), "Something", "me"),
            new Post("Hello", LocalDate.of(2020, 05, 01), "Something", "you"),
            new Post("Hello", LocalDate.of(2021, 02, 10), "Something", "me")
    ));


    assertEquals("Today", pf.findPostsFor("me").get(1).getContent());
    assertEquals(3, pf.findPostsFor("me").size());

  }

  @Test
  public void testEmptyParamOfTitleOrContent() {

    assertThrows(IllegalArgumentException.class, () -> new PostFinder(Arrays.asList(
            new Post("Hello", LocalDate.of(2021, 01, 01), "Something", "me"),
            new Post("Hello", LocalDate.of(2021, 02, 01), "Today", "me"),
            new Post("Hello", LocalDate.of(2021, 05, 01), "", "you"),
            new Post("Hello", LocalDate.of(2021, 02, 10), "Something", "me")
    )));

  }
}