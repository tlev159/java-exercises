package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerDao {

  private DataSource dataSource;

  public ActivityTrackerDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void createActivity(Activity activity) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt =
                 conn.prepareStatement("INSERT INTO activitytracker (start_time, activity_desc, activity_type) VALUES (?,?,?)")
    ) {
      stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTine()));
      stmt.setString(2, activity.getDesc());
      stmt.setString(3, activity.getType().toString());
      stmt.executeUpdate();
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not insert data!", se);
    }

  }
}
