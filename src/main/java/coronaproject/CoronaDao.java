package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

  public List<Citizens> insertGroupOfCitizens(List<Citizens> citizens) {
    try (Connection conn = dataSource.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps = conn.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)",
              Statement.RETURN_GENERATED_KEYS)
      ) {
        List<Integer> failedRows = new ArrayList<>();
        int i = 1;
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
    return citizens;
  }

  public void vaccination(LocalDate date, String taj, VaccinType type) {

  }

  public List<Citizens> findCitizensWithGivenPostalCode(int postalCode) {
    List<Citizens> temp = new ArrayList<>();
    try (Connection conn = dataSource.getConnection();
//         PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE zip = ?")
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE number_of_vaccination < 2 and zip = ? ORDER BY age DESC, citizen_name LIMIT 16")
    ) {
      ps.setLong(1, postalCode);

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          LocalDateTime nullTime = LocalDateTime.of(0, 1, 1, 0, 0);
          if (rs.getTimestamp("last_vaccination") != null && rs.getTimestamp("last_vaccination").toLocalDateTime() != nullTime) {
            Citizens citizen = new Citizens(rs.getLong("citizen_id"), rs.getString("citizen_name"), rs.getInt("zip"), rs.getInt("age"), rs.getString("email"), rs.getString("taj"), rs.getLong("number_of_vaccination"), nullTime);
            temp.add(citizen);
          } else {
            Citizens citizen = new Citizens(rs.getLong("citizen_id"), rs.getString("citizen_name"), rs.getInt("zip"), rs.getInt("age"), rs.getString("email"), rs.getString("taj"), rs.getLong("number_of_vaccination"), nullTime);
            temp.add(citizen);
          }
        }
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
    return temp;
  }

  public String findTownWithTheGivenZip(int zip) {
    String result = "";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT city FROM cities WHERE zip = ?");
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

  public Citizens searchForExistingTaj(String taj) {
    Citizens temp = null;
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM citizens WHERE taj = ?");
    ) {
      stmt.setString(1, taj);

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          long id = rs.getLong("citizen_id");
          String name = rs.getString("citizen_name");
          int zip = rs.getInt("zip");
          int age = rs.getInt("age");
          String email = rs.getString("email");
          long numberOfVaccination = rs.getLong("number_of_vaccination");
          temp = new Citizens(id, name, zip, age, email, taj);
          temp.setNumberOfVaccination(numberOfVaccination);
          if (rs.getTimestamp("last_vaccination") != null) {
            System.out.println("last: " + rs.getTimestamp("last_vaccination").toLocalDateTime());
            temp.setLastVaccination(rs.getTimestamp("last_vaccination").toLocalDateTime());
          }
        }
        return temp;
      } catch (SQLException se) {
        throw new IllegalStateException("Can not find town!", se);
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

  public Citizens searchCitizenAndVaccinationByTaj(String taj) {
    Citizens temp = null;
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vaccinations v JOIN citizens c WHERE c.citizen_id = v.citizen_id AND c.citizen_id = ?");
    ) {

      temp = searchForExistingTaj(taj);
      stmt.setLong(1, temp.getId());

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          LocalDateTime date = rs.getTimestamp("vaccination_date").toLocalDateTime();
          String status = rs.getString("status");
          String note = rs.getString("note");
//          temp.setNumberOfVaccination(temp.getNumberOfVaccination() + 1);
          temp.setLastVaccination(date);
          VaccinType type = VaccinType.valueOf(rs.getString("vaccination_type"));
          temp.addVaccination(new Vaccinations(date, status, note, type));
        }
        return temp;
      } catch (SQLException se) {
        throw new IllegalStateException("Can not find town!", se);
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }


}
