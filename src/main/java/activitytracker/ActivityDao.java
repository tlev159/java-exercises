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
         PreparedStatement stmt1 =
                 conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?,?,?)",
                         Statement.RETURN_GENERATED_KEYS);
         PreparedStatement stmt2 =
                 conn.prepareStatement("INSERT INTO track_point (time, lat, lon, activity_id) VALUES (?,?,?,?)",
                         Statement.RETURN_GENERATED_KEYS);
    ) {
      stmt1.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
      stmt1.setString(2, activity.getDesc());
      stmt1.setString(3, activity.getType().toString());
      stmt1.executeUpdate();
      Activity temp = getIdByStatement(stmt1);

      insertActivityTrackPoints(activity.getTrackerPoints(), temp.getId());
//      try (ResultSet rs = stmt.getGeneratedKeys()) {
//        if (rs.next()) {
//          long id = rs.getLong(1);
//          return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
//        }
//      }

      return temp;
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not insert data!", se);
    }
  }

  private void insertActivityTrackPoints(List<TrackPoint> trackPoints, long activityId) {
    try (Connection conn = dataSource.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps = conn.prepareStatement("INSERT INTO track_point (time, lat, lon, activity_id) VALUES (?,?,?,?)",
              Statement.RETURN_GENERATED_KEYS)
      ) {
        for (TrackPoint trackPoint : trackPoints) {
          if (!isValidLatLon(trackPoint.getLat(), trackPoint.getLon())) {
            throw new IllegalStateException("Invalid track point!");
          }
          ps.setDate(1, Date.valueOf(trackPoint.getTime()));
          ps.setDouble(2, trackPoint.getLat());
          ps.setDouble(3, trackPoint.getLon());
          ps.setLong(4, activityId);
          ps.executeUpdate();
        }
        conn.commit();

      } catch (SQLException se) {
        conn.rollback();
        throw new IllegalStateException("Can not insert trackpoint", se);
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect!", se);
    }
  }

  private boolean isValidLatLon(double lat, double lon) {
    if (lat < -90 || lat > 90) {
      return false;
    }
    if (lon < -180 || lon > 180) {
      return false;
    }
    return true;
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
