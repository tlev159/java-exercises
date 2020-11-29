package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

  private List<Song> songs = new ArrayList<>();

  public Playlist(List<Song> songs) {
    this.songs = songs;
  }

  public List<String> findByLengthGreaterThan(int mins) {
    List<String> longerThanMinsSongs = new ArrayList<>();

    for (Song song: songs) {
      if (song.getLengthInSeconds() < (mins * 60)) {
        longerThanMinsSongs.add(song.toString());
      }
    }
    return longerThanMinsSongs;
  }

  public List<Song> getSongs() {
    return songs;
  }

  @Override
  public String toString() {
    return "" + songs;
  }
}
