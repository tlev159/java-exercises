package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

  public Trainer trainerWithMaxAge(List<Trainer> trainers) {
    int maxAge = 0;
    Trainer oldestTrainer = new Trainer("", 0);
    for (Trainer t : trainers) {
      if (maxAge > t.getAge()) {
        maxAge = t.getAge();
        oldestTrainer = t;
      }
    }
    return oldestTrainer;
  }
}
