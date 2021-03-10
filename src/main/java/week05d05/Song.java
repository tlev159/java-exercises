package week05d05;

public class Song {

  private String name;
  private long lengthInSeconds;
  private String artist;

  public Song(String name, long lengthInSeconds, String artist) {
    areTheParametersValid(name, lengthInSeconds, artist);
    this.name = name;
    this.lengthInSeconds = lengthInSeconds;
    this.artist = artist;
  }

  private void areTheParametersValid(String name, long lengthInSeconds, String artist) {
    if (isEmpty(name)) {
      throw new IllegalArgumentException("Name must not be null or empty!");
    }
    if (lengthInSeconds <= 0) {
      throw new IllegalArgumentException("The length of the song must not be shorter as 1 second!");
    }
    if (isEmpty(artist)) {
      throw new IllegalArgumentException("Artist must not be null or empty!");
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
