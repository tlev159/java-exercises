package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

  private List<Activity> activities;

  public Activities(List<Activity> activities) {
    this.activities = activities;
  }

  public void addActivity(Activity activity) {
    activities.add(activity);
  }

  public List<Report> distancesByTypes() {
    List<Report> reports = new ArrayList<>();
    double bikingDistance = 0.0;
    double hikingDistance = 0.0;
    double runningDistance = 0.0;
    double basketballDistance = 0.0;
    for (Activity a:activities) {
      switch (a.getType()) {
        case BIKING:
          bikingDistance += a.getDistance();
          break;
        case HIKING:
          hikingDistance += a.getDistance();
          break;
        case RUNNING:
          runningDistance += a.getDistance();
          break;
        case BASKETBALL:
          basketballDistance += a.getDistance();
          break;
      }
    }
    reports.add(new Report(ActivityType.BIKING, bikingDistance));
    reports.add(new Report(ActivityType.HIKING, hikingDistance));
    reports.add(new Report(ActivityType.RUNNING, runningDistance));
    reports.add(new Report(ActivityType.BASKETBALL, basketballDistance));
    return reports;
  }

  public int numberOfTrackActivities() {
    int numberOfActivitiesWithTrack = 0;
    for (Activity a: activities) {
      if (a instanceof ActivityWithTrack) {
          numberOfActivitiesWithTrack++;
      }
    }
    return  numberOfActivitiesWithTrack;
  }

  public int numberOfWithoutTrackActivities() {
    int numberOfActivitiesWithoutTrack = 0;
    for (Activity a: activities) {
      if (a instanceof ActivityWithoutTrack) {
          numberOfActivitiesWithoutTrack++;
      }
    }
    return  numberOfActivitiesWithoutTrack;
  }

}
