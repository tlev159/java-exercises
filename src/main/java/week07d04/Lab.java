package week07d04;

import java.time.LocalDate;

public class Lab {

  private String title;
  private boolean completed;
  private LocalDate completedAt;

  public Lab(String title) {
    this.title = title;
    this.completed = false;
  }

  public Lab(String title, LocalDate completedAt) {
    this.title = title;
    this.completed = true;
    this.completedAt = completedAt;
  }

  public void complete(LocalDate date) {
    this.completed = true;
    this.completedAt = date;
  }

  public void complete() {
    this.completed = true;
    this.completedAt = LocalDate.now();
  }

  public String getTitle() {
    return title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public LocalDate getCompletedAt() {
    return completedAt;
  }

  @Override
  public String toString() {
    return title + "(completed?: " + completed + "), completed at:" + completedAt;
  }
}
