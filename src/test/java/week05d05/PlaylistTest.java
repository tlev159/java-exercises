package week05d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaylistTest {


  @Test
  public void testEmptyName() {

    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      List<Song> songs = new ArrayList<>();
      songs.add(new Song("John Doe", 120, "Java Band"));
      songs.add(new Song("Jack filling the test", 110, "Java Band"));
      songs.add(new Song("Morning awakings", 124, "Longsleepers"));
      songs.add(new Song("", 130, "Bandidas"));
      songs.add(new Song("The Leopard", 130, "Band of Animallovers"));
      songs.add(new Song("King Atrhur", 150, "Sunflower Band"));
      songs.add(new Song("Time is over", 10, "Buffalo Band"));
    });

    assertEquals("Name must not be null or empty!", ex.getMessage());
  }

  @Test
  public void testEmptyArtist() {

    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      List<Song> songs = new ArrayList<>();
      songs.add(new Song("John Doe", 120, "Java Band"));
      songs.add(new Song("Jack filling the test", 110, "Java Band"));
      songs.add(new Song("Morning awakings", 124, "Longsleepers"));
      songs.add(new Song("Tutti Frutti", 130, ""));
      songs.add(new Song("The Leopard", 130, "Band of Animallovers"));
      songs.add(new Song("King Atrhur", 150, "Sunflower Band"));
      songs.add(new Song("Time is over", 10, "Buffalo Band"));
    });

    assertEquals("Artist must not be null or empty!", ex.getMessage());
  }

  @Test
  public void testLengthOfSongNotGreaterThanNull() {

    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      List<Song> songs = new ArrayList<>();
      songs.add(new Song("John Doe", 120, "Java Band"));
      songs.add(new Song("Jack filling the test", 110, "Java Band"));
      songs.add(new Song("Morning awakings", 124, "Longsleepers"));
      songs.add(new Song("Tutti Frutti", 130, "Bandidas"));
      songs.add(new Song("The Leopard", 0, "Band of Animallovers"));
      songs.add(new Song("King Atrhur", 150, "Sunflower Band"));
      songs.add(new Song("Time is over", 10, "Buffalo Band"));
    });

    assertEquals("The length of the song must not be shorter as 1 second!", ex.getMessage());
  }

  @Test
  public void testListOfSongsGreaterInMinAsGiven() {

    List<Song> songs = new ArrayList<>();
      songs.add(new Song("John Doe", 120, "Java Band"));
      songs.add(new Song("Jack filling the test", 110, "Java Band"));
      songs.add(new Song("Morning awakings", 124, "Longsleepers"));
      songs.add(new Song("Tutti Frutti", 130, "Bandidas"));
      songs.add(new Song("The Leopard", 140, "Band of Animallovers"));
      songs.add(new Song("King Atrhur", 150, "Sunflower Band"));
      songs.add(new Song("Time is over", 10, "Buffalo Band"));

    Playlist playlist = new Playlist(songs);

    List<Song> shorterSongs = new ArrayList<>();

      shorterSongs.add(new Song("Jack filling the test", 110, "Java Band"));
      shorterSongs.add(new Song("Time is over", 10, "Buffalo Band"));

    assertEquals(shorterSongs.toString(), playlist.findByLengthGreaterThan(2).toString());
  }

}
