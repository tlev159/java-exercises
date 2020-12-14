package week08d01;

public class Robot {

  public int[] move(String move) {
    String[] m = move.trim().split("");
    int[] position = {0,0};
    for (String c:m) {
      if (!"B".equals(c.toUpperCase()) && !"F".equals(c.toUpperCase()) && !"J".equals(c.toUpperCase()) && !"L".equals(c.toUpperCase())) {
        throw new IllegalArgumentException("Csak F, L, B, J betűk lehetnek!");
      }
      takeTheMove(c, position);
    }
    return position;
  }

  public String moveFromGivenPosition(int[] position, String move) {

    String[] m = move.trim().split("");
    for (String c:m) {
      if (!"B".equals(c.toUpperCase()) && !"F".equals(c.toUpperCase()) && !"J".equals(c.toUpperCase()) && !"L".equals(c.toUpperCase())) {
        throw new IllegalArgumentException("Csak F, L, B, J betűk lehetnek!");
      }
      takeTheMove(c, position);
    }
    return "Pos.(x,y): " + position[0] + "," + position[1];
  }

  public void takeTheMove(String c, int[] position) {
    switch (c) {
      case "B":
        moveLeft(position);
        break;
      case "F":
        moveUp(position);
        break;
      case "J":
        moveRight(position);
        break;
      case "L":
        moveDown(position);
        break;
    }

  }

  public void moveLeft(int[] position) {
    position[0]--;
  }

  public void moveRight(int[] position) {
    position[0]++;
  }

  public void moveUp(int[] position) {
    position[1]++;

  }

  public void moveDown(int[] position) {
    position[1]--;
  }

}
