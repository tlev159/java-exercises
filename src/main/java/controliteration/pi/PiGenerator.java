package controliteration.pi;

public class PiGenerator {

  private String piVers = "Nem a régi s durva közelítés,\n"+
          "Mi szótól szóig így kijön\n" +
          "Betűiket számlálva.\n" +
          "Ludolph eredménye már,\n" +
          "Ha itt végezzük húsz jegyen.\n" +
          "De rendre kijő még tíz pontosan,\n" +
          "Azt is bízvást ígérhetem.";

  public String getPi() {
//    String[] words = piVers.split(" ");
    String pi = "";
    int digit = 0;
//    System.out.println(pi.length());
    for (int i = 0; i < piVers.length(); i++) {
//      System.out.println(i + ". " + words[i]);
      if (pi.length() == 1) {
        pi += ".";
      }
      if (Character.isAlphabetic(piVers.charAt(i))) {
        digit++;
      } else if (digit > 0){
        pi += digit;
        digit = 0;
      }
//      System.out.println(i + ". " + digit);
    }
    System.out.println("Pi: " + pi);
    return pi;
  }

  public static void main(String[] args) {
    PiGenerator piGenerator = new PiGenerator();
    piGenerator.getPi();
  }
}
