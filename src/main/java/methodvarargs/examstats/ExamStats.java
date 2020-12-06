package methodvarargs.examstats;

public class ExamStats {

  private int maxPoints;

  public ExamStats(int maxPoints) {
    this.maxPoints = maxPoints;
  }

  public int getNumberOfTopGrades(int limitInPercent, int... results) {
    if (results == null || results.length < 1) {
      throw new IllegalArgumentException("Number of results must not be empty!");
    }
    int numberOfSolvedExams = 0;
    for (int i:results) {
      if (i > (double) maxPoints * limitInPercent / 100) {
        numberOfSolvedExams++;
      }
    }
    return numberOfSolvedExams;
  }

  public boolean hasAnyFailed(int limitInPercent, int... results) {
    if (results == null || results.length < 1) {
      throw new IllegalArgumentException("Number of results must not be empty!");
    }
    for (int i:results) {
      if (i < (double) maxPoints * limitInPercent / 100) {
        return true;
      }
    }
    return false;
  }

}
