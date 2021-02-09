package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

  private List<Questions> questions = new ArrayList<>();

  public List<Questions> getQuestions() {
    return questions;
  }

  public void readDatasFromFile(Path path) {
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String question = line;
        line = reader.readLine();
        addQuestionData(question, line);
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Can not read file!", ioe);
    }
  }

  public void addQuestionData(String question, String answerLine) {
    String[] q = answerLine.split(" ");
    questions.add(new Questions(question, q[0], Integer.parseInt(q[1]), q[2]));
  }

  public List<String> questionsOfATopic(String topic) {
    if (topic == null || topic.isBlank()) {
      throw new IllegalArgumentException("Wrong topic name!");
    }
    List<String> result = new ArrayList<>();
    for (Questions q : questions) {
      if (q.getTopic().equals(topic)) {
        result.add(q.getQuestion());
      }
    }
    if (result.size() == 0) {
      throw new IllegalArgumentException("Topic was not found!");
    } else {
      return result;
    }
  }

  public Questions randomSelectQuestion() {
    Random rnd = new Random();
    int index = rnd.nextInt(questions.size());
    return questions.get(index);
  }

  public Map<String, List<Questions>> questionsSortedByTopics() {
    Map<String, List<Questions>> result = new HashMap<>();
    for (Questions q : questions) {
      if (!result.containsKey(q.getTopic())) {
        result.put(q.getTopic(), new ArrayList<>());
      }
      result.get(result.get(q.getTopic()).add(q));
    }
    return result;
  }

  public String MostSumPointTopic() {
    Map<String, List<Questions>> temp = questionsSortedByTopics();
    int maxSumOfPoints = 0;
    String result = "";
    for (String key : temp.keySet()) {
      int sumOfPoints = 0;
      for (Questions questions : temp.get(key)) {
        sumOfPoints += questions.getPoint();
      }
      if (maxSumOfPoints < sumOfPoints) {
        maxSumOfPoints = sumOfPoints;
        result = temp.get(key).get(0).getTopic();
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Path path = Path.of("src/main/resources/kerdesek.txt");
    Quiz quiz = new Quiz();
    quiz.readDatasFromFile(path); // read file
//    System.out.println(quiz.questions); // readingproof
//    System.out.println(quiz.questionsOfATopic("matematika")); // 1.
//    System.out.println(quiz.randomSelectQuestion()); //2.
//    System.out.println(quiz.questionsSortedByTopics()); //3-
    System.out.println(quiz.MostSumPointTopic()); // 4.
  }
}
