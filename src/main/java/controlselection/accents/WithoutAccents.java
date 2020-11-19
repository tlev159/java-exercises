package controlselection.accents;

public class WithoutAccents {

  public char convertToCharWithoutAccents(char c) {
    switch (c) {
      case 'á':
        return 'a';
      case 'Á':
        return 'A';
      case 'é':
        return 'e';
      case 'É':
        return 'E';
      case 'í':
        return 'i';
      case 'Í':
        return 'I';
      case 'ö':
      case 'ő':
        return 'o';
      case 'ú':
      case 'ü':
      case 'ű':
        return 'u';
      case 'Ú':
      case 'Ü':
      case 'Ű':
        return 'U';
      default:
        return c;
    }
  }
}
