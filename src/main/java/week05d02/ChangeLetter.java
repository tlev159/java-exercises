package week05d02;

public class ChangeLetter {

  private static final String VOLWES = "aAeEiIoOuU";
  private static final String VOLWES2 = "aeiou";

  public String changeVowels(String string) {
    for (int i = 0; i < VOLWES.length(); i++) {
      string = string.replace(VOLWES.charAt(i), '*');
    }
    return string;
  }

  public String changeVowels2(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      String subS = s.substring(i, i + 1);
      if (VOLWES2.contains(subS.toLowerCase())) {
        sb.append("*");
      } else {
        sb.append(subS);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ChangeLetter changeLetter = new ChangeLetter();
    System.out.println(changeLetter.changeVowels("Kezdetben vala az utazokozonseg..."));
  }
}
