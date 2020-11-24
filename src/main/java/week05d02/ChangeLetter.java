package week05d02;

public class ChangeLetter {

  public String changeVowels(String string) {
    String[] volwes = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};
    for (int i = 0; i < volwes.length; i++) {
      string = string.replace(volwes[i], "*");
    }
    return string;
  }

  public static void main(String[] args) {
    ChangeLetter changeLetter = new ChangeLetter();
    System.out.println(changeLetter.changeVowels("Kezdetben vala az utazokozonseg..."));
  }
}
