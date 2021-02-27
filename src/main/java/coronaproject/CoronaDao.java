package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.List;

public class CoronaDao {

  private MariaDbDataSource dataSource;


  public CoronaDao(MariaDbDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void addCitizenToDatabase(Citizens citizen) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)",
                 Statement.RETURN_GENERATED_KEYS);
    ) {
      stmt.setString(1, citizen.getFullName());
      stmt.setInt(2, citizen.getZip());
      stmt.setLong(3, citizen.getAge());
      stmt.setString(4, citizen.getEmail());
      stmt.setString(5, citizen.getTaj());
      if (searchForExistingTaj(citizen.getTaj()) == null) {
        stmt.executeUpdate();
      } else {
        throw new IllegalArgumentException("Már létezik ilyen TAJ-szám!");
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

  public void insertGroupOfCitizens(List<Citizens> citizens) {
    try (Connection conn = dataSource.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps = conn.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)",
                   Statement.RETURN_GENERATED_KEYS)
      ) {
        for (Citizens citizen : citizens) {
          ps.setString(1, citizen.getFullName());
          ps.setInt(2, citizen.getZip());
          ps.setLong(3, citizen.getAge());
          ps.setString(4, citizen.getEmail());
          ps.setString(5, citizen.getTaj());
          if (searchForExistingTaj(citizen.getTaj()) == null) {
            ps.executeUpdate();
          } else {
            throw new IllegalArgumentException("Már létezik ilyen TAJ-szám!");
          }
        }
        conn.commit();
      } catch (SQLException se) {
        conn.rollback();
        throw new IllegalStateException("Can not insert citizens!", se);
      }

    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

  public String findTownWithTheGivenZip(int zip) {
    String result = "";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT city FROM iranyitoszamok WHERE city_id = ?");
    ) {
      stmt.setLong(1, zip);

      result = findTownWithZip(result, stmt);

    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
    return result;
  }

  private String findTownWithZip(String result, PreparedStatement stmt) {
    try (ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        result = rs.getString("city");
      }

    } catch (SQLException se) {
      throw new IllegalStateException("Can not find town!", se);
    }
    return result;
  }

  public String searchForExistingTaj(String taj) {
    String result = null;
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM citizens WHERE taj = ?");
    ) {
      stmt.setString(1, taj);

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          result = rs.getString("taj");
        }
        return result;
      } catch (SQLException se) {
        throw new IllegalStateException("Can not find town!", se);
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

}
