package week05d05;

public class Song {

  private String name;
  private long lengthInSeconds;
  private String artist;

  public Song(String name, long lengthInSeconds, String artist) {
    if (isEmpty(name)) {
      throw new IllegalArgumentException("Name must not be null or empty!");
    } else {
      this.name = name;
    }
    if (lengthInSeconds <= 0) {
      throw new IllegalArgumentException("The length of the song must not be shorter as 1 second!");
    } else {
      this.lengthInSeconds = lengthInSeconds;
    }
    if (isEmpty(artist)) {
      throw new IllegalArgumentException("Artist must not be null or empty!");
    } else {
      this.artist = artist;
    }
  }

  public String getName() {
    return name;
  }

  public long getLengthInSeconds() {
    return lengthInSeconds;
  }

  public String getArtist() {
    return artist;
  }

  @Override
  public String toString() {
    return name + " - " + artist + " (" + lengthInSeconds + " sec)";
  }

  private boolean isEmpty(String str) {
    return str == null || str.isBlank();
  }

}
