package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

  private DataSource dataSource;

  public ActivityDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Activity saveActivity(Activity activity) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt =
                 conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?,?,?)",
                         Statement.RETURN_GENERATED_KEYS)
    ) {
      stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
      stmt.setString(2, activity.getDesc());
      stmt.setString(3, activity.getType().toString());
      stmt.executeUpdate();

//      try (ResultSet rs = stmt.getGeneratedKeys()) {
//        if (rs.next()) {
//          long id = rs.getLong(1);
//          return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
//        }
//      }

      return getIdByStatement(stmt);
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not insert data!", se);
    }
  }

  public List<Activity> selectActivitiesBeforeDate(LocalDate date) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities WHERE start_time < ?");
    ) {
//      ps.setString(1, date.toString);

      LocalDateTime actualDate = date.atTime(0,0);
      ps.setTimestamp(1, Timestamp.valueOf(actualDate));
      return selectActivityPreparedStatement(ps);
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not connect!", se);
    }
  }

  private void isDateBeforGivenDate(LocalDate date, List<Activity> result, List<Activity> temp) {
    for (Activity activity : temp) {
      if (activity.getStartTime().isBefore(LocalDateTime.of(date, LocalTime.of(0,0)))) {
        result.add(activity);
      }
    }
  }

  private Activity getIdByStatement(PreparedStatement stmt) {
    try (ResultSet rs = stmt.getGeneratedKeys()){
      if (rs.next()) {
        return findActivityById(rs.getLong(1));
      }
      throw new IllegalStateException("Can not get id!");
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not get id!", se);
    }
  }

  public Activity findActivityById(long id) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * from activities WHERE id = ?")
    ) {
      ps.setLong(1, id);
      List<Activity> temp = selectActivityPreparedStatement(ps);
      if (temp.size() == 1) {
        return temp.get(0);
      }
      throw new IllegalArgumentException("Not found!");
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not found data by Id!", se);
    }
  }

  private List<Activity> selectActivityPreparedStatement(PreparedStatement ps) {
    List<Activity> activities = new ArrayList<>();
    try (ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Activity activity = new Activity(rs.getLong("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("activity_desc"),
                ActivityType.valueOf(rs.getString("activity_type")));
        activities.add(activity);
      }
      return activities;
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not found!", se);
    }
  }

  public List<Activity> listActivities() {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities");
    ) {
      return selectActivityPreparedStatement(ps);
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not query!", se);
    }
  }

  public List<Activity> selectByType(ActivityType type) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM activities WHERE activity_type = ?")
    ){
      ps.setString(1, type.toString());
      return selectActivityPreparedStatement(ps);
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can no connect to database!", se);
    }
  }

}
