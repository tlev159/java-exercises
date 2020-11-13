package classstructureattributes;

import java.util.Scanner;

public class Music {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Song song = new Song();

    System.out.println("Kérem a kedvenc zenéd adatait:");
    System.out.println("Az előadó/együttes neve:");
    song.band = scanner.nextLine();
    System.out.println("A szám címe:");
    song.title = scanner.nextLine();
    System.out.println("A szám hossza percben:");
    song.length = scanner.nextInt();

    System.out.println(song.band + " - " + song.title +  " (" + song.length + " perc)");
  }
}
