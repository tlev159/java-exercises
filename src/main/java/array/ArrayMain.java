package array;

public class ArrayMain {

  public static void main(String[] args) {
    String[] weekdays = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
    System.out.println(weekdays[1]);
    System.out.println(weekdays.length);

    int[] evenNumbers = new int[5];
    int a = 1;
    for (int i = 0; i < 5; i++) {
      evenNumbers[i] = a;
      a *= 2;
    }
    for (int numbers: evenNumbers) {
      System.out.print(numbers + " ");
    }

    System.out.println();

    boolean[] isTrueOrFalse = new boolean[6];
    isTrueOrFalse[0] = false;
    for (int i = 1; i < isTrueOrFalse.length; i++) {
        isTrueOrFalse[i] = !isTrueOrFalse[i-1];
    }
    for (boolean trueFalse: isTrueOrFalse) {
      System.out.print(trueFalse + " ");
    }

  }
}
