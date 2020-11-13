package localvariables;

public class DistanceMain {

  public static void main(String[] args) {
    Distance distance = new Distance();

    System.out.println("Távolság: " + distance.getDistance());
    System.out.println("Pontos-e: " + distance.isCorrect());

    int a = (int) distance.getDistance();
    System.out.println("a: " + a);


  }
}
