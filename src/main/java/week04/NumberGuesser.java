package week04;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {



  public static void main(String[] args) {
    Random rnd = new Random();

    int guessedNumber = rnd.nextInt(100) + 1;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Kitaláltam egy számot 1 és 100 között!");
    System.out.println("Találd ki, melyik számra gondoltam!");
    int number = 0;
    int round = 0;
    while (guessedNumber != number && round < 7) {
      round++;
      System.out.println(round + ". kör a 7-ből");
      number = scanner.nextInt();
      if (guessedNumber > number) {
        System.out.println("A kitalált szám ennél nagyobb!");
      } else if (guessedNumber < number){
        System.out.println("A kitalált szám ennél kisebb!");
      } else System.out.println("Kitaláltad!");
    }

    System.out.println("A gondolt szám: " + guessedNumber);


  }
}
