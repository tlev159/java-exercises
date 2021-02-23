package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityTrackerMain {

  public static void main(String[] args) {


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

    ActivityDao trackerDao = new ActivityDao(dataSource);


    System.out.println(trackerDao.findActivityById(2L).toString());

    List<Activity> activities = trackerDao.listActivities();
    for (Activity activity : activities) {
      System.out.println(activity.toString());
    }

  }
}
