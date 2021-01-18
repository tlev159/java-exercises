package week12d01;

public class GradeRounder {

  public int[] roundGrades(int[] grades) {
    int[] result = new int[grades.length];
    for (int i = 0; i < grades.length; i++) {
      if (grades[i] < 40) {
        result[i] = grades[i];
      } else if (grades[i] % 5 > 2) {
        result[i] = grades[i] + (5 - grades[i] % 5);
      } else {
        result[i] = grades[i];
      }
    }
    return result;
  }

}
