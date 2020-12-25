package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable{

  private List<String> tasks;

  public SimpleThread(List<String> tasks) {
    this.tasks = tasks;
  }

  private boolean nextStep() {
    tasks.remove(tasks.size()-1);
    if (tasks.size() > 0) {
      return true;
    }
    return false;
  }

  public void run() {
    while (tasks.size() > 0) {
      nextStep();
    }
  }

  public List<String> getTasks() {
    return tasks;
  }

}
