package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CoronaDao {

  private MariaDbDataSource dataSource;


  public CoronaDao(MariaDbDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public boolean addCitizenToDatabase(Citizen citizen) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)",
                 Statement.RETURN_GENERATED_KEYS);
    ) {
      stmt.setString(1, citizen.getFullName());
      stmt.setInt(2, citizen.getZip());
      stmt.setLong(3, citizen.getAge());
      stmt.setString(4, citizen.getEmail());
      stmt.setString(5, citizen.getTaj());
//      if (searchForExistingTaj(citizen.getTaj()) == null) {
        stmt.executeUpdate();
//      } else {
//        System.out.println("Már létezik ilyen TAJ-szám!");
//
//      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
    return true;
  }

  public List<Citizen> insertGroupOfCitizens(List<Citizen> citizens) {
    try (Connection conn = dataSource.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps = conn.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?,?,?,?,?)",
              Statement.RETURN_GENERATED_KEYS)
      ) {
        List<Integer> failedRows = new ArrayList<>();
        int i = 1;
        for (Citizen citizen : citizens) {

          ps.setString(1, citizen.getFullName());
          ps.setInt(2, citizen.getZip());
          ps.setLong(3, citizen.getAge());
          ps.setString(4, citizen.getEmail());
          ps.setString(5, citizen.getTaj());
//          if (searchForExistingTaj(citizen.getTaj()) == null) {
            ps.executeUpdate();
//          } else {
//            throw new IllegalArgumentException("Már létezik ilyen TAJ-szám!");
//          }
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
    Citizen citizen = searchCitizenAndVaccinationByTaj(taj);
    long citizenId = citizen.getId();
    long numberOfVaccination = citizen.getNumberOfVaccination();
    LocalDate dateTime;
    if (citizen.getLastVaccination() != null) {
      dateTime = citizen.getLastVaccination();
    } else {
      dateTime = date;
    }
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps1 = conn.prepareStatement("UPDATE citizens SET number_of_vaccination = ?, last_vaccination = ? WHERE taj = ?");
         PreparedStatement ps2 = conn.prepareStatement("INSERT INTO vaccinations (citizen_id, vaccination_date, status, vaccination_type) VALUES (?,?,?,?)")
    ) {
      ps1.setString(3, taj);
      try {
        ps1.setLong(1, numberOfVaccination + 1);
        ps1.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(date, LocalTime.of(16, 0))));
        ps2.setLong(1, citizenId);
        ps2.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(dateTime, LocalTime.of(16,0))));
        ps2.setString(3, "GIVEN");
        ps2.setString(4, type.toString());
        ps1.executeUpdate();
        ps2.executeUpdate();
      } catch (SQLException se) {
        throw new IllegalStateException("Can not insert datas!", se);
      }
      System.out.println("A frissítés sikeres volt!");
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

  public void deleteVaccinationWithNotes(String taj, String notes) {
    Citizen citizen = searchCitizenAndVaccinationByTaj(taj);
    long citizenId = citizen.getId();
    LocalDate date = LocalDate.now();
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("INSERT INTO vaccinations (citizen_id, vaccination_date, status, note) VALUES (?,?,?,?)")
    ) {
      try {
        ps.setLong(1, citizenId);
        ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(date, LocalTime.now())));
        ps.setString(3, "DELETED");
        ps.setString(4, notes);
        ps.executeUpdate();
      } catch (SQLException se) {
        throw new IllegalStateException("Can not insert datas!", se);
      }
      System.out.println("A frissítés sikeres volt!");
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!", se);
    }
  }

  public List<Citizen> findCitizensWithGivenPostalCode(int postalCode) {
    List<Citizen> temp = new ArrayList<>();
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE number_of_vaccination < 2 and zip = ? ORDER BY age DESC, citizen_name LIMIT 16")
    ) {
      ps.setLong(1, postalCode);

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          if (rs.getTimestamp("last_vaccination") != null) {
            Citizen citizen = new Citizen(rs.getLong("citizen_id"), rs.getString("citizen_name"), rs.getInt("zip"), rs.getInt("age"), rs.getString("email"), rs.getString("taj"), rs.getLong("number_of_vaccination"), rs.getTimestamp("last_vaccination").toLocalDateTime().toLocalDate());
            temp.add(citizen);
          } else {
            Citizen citizen = new Citizen(rs.getLong("citizen_id"), rs.getString("citizen_name"), rs.getInt("zip"), rs.getInt("age"), rs.getString("email"), rs.getString("taj"), rs.getLong("number_of_vaccination"));
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

  public Citizen searchForExistingTaj(String taj) {
    Citizen temp = null;
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
          temp = new Citizen(id, name, zip, age, email, taj);
          temp.setNumberOfVaccination(numberOfVaccination);
          if (rs.getTimestamp("last_vaccination") != null) {
            temp.setLastVaccination(rs.getTimestamp("last_vaccination").toLocalDateTime().toLocalDate());
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

  public Citizen searchCitizenAndVaccinationByTaj(String taj) {
    Citizen temp = null;
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vaccinations v JOIN citizens c WHERE c.citizen_id = v.citizen_id AND c.citizen_id = ?");
    ) {
      temp = searchForExistingTaj(taj);
      stmt.setLong(1, temp.getId());
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          LocalDate date = rs.getTimestamp("vaccination_date").toLocalDateTime().toLocalDate();
          String status = rs.getString("status");
          String note = rs.getString("note");
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

  public List<ReportForVaccination> giveRegisteredCitizensBack() {
    List<ReportForVaccination> report = new ArrayList<>();
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("Select zip, number_of_vaccination FROM citizens")
    ) {
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        report.add(new ReportForVaccination(rs.getInt("zip"), rs.getInt("number_of_vaccination")));
      }
    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect!", se);
    }
    return report;
  }

}
