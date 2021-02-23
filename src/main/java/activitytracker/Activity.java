package activitytracker;

import java.time.LocalDateTime;

public class Activity {

  private int id;
  private LocalDateTime startTine;
  private String desc;
  private ActivityType type;

  public Activity(int id, LocalDateTime startTine, String desc, ActivityType type) {
    this.id = id;
    this.startTine = startTine;
    this.desc = desc;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getStartTine() {
    return startTine;
  }

  public String getDesc() {
    return desc;
  }

  public ActivityType getType() {
    return type;
  }
}
