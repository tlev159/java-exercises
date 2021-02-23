package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

  public static void main(String[] args) {

    Activity activity1 = new Activity(1, LocalDateTime.of(2021, 02, 13, 10, 13), "Going to play bascetball", ActivityType.BASKETBALL);
    Activity activity2 = new Activity(1, LocalDateTime.of(2021, 02, 13, 14, 13), "Biking in the town", ActivityType.BIKING);
    Activity activity3 = new Activity(1, LocalDateTime.of(2021, 02, 16, 11, 13), "Hiking in the town", ActivityType.HIKING);
    Activity activity4 = new Activity(1, LocalDateTime.of(2021, 02, 20, 16, 13), "Running in the wood", ActivityType.RUNNING);

    MariaDbDataSource dataSource;
    try {
      dataSource = new MariaDbDataSource();
      dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
      dataSource.setUser("activitytracker");
      dataSource.setPassword("activitytracker");
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not create data source!", se);
    }

    Flyway flyway = Flyway.configure().dataSource(dataSource).load();

    flyway.clean();
    flyway.migrate();

    ActivityTrackerDao trackerDao = new ActivityTrackerDao(dataSource);
    trackerDao.createActivity(activity1);


  }
}
