package controlselection.consonant;

public class ToConsonant {

  public char convertToConsonant(char c) {
    switch (c) {
      case 'a':
        return 'b';
      case 'e':
        return 'f';
      case 'i':
        return 'j';
      case 'o':
        return 'p';
      case 'u':
        return 'v';
    }
    return c;
  }
}
