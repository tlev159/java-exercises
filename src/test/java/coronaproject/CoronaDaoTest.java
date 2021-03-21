package coronaproject;

import activitytracker.ActivityDao;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CoronaDaoTest {

  CoronaDao coronaDao;

  @BeforeEach
  public void init() {
    MariaDbDataSource dataSource;

    try {
      dataSource = new MariaDbDataSource();
      dataSource.setUrl("jdbc:mariadb://localhost:3306/corona?useUnicode=true");
      dataSource.setUser("coronavaccinadmin");
      dataSource.setPassword("coronavaccin");
    }
    catch (SQLException se) {
      throw new IllegalStateException("Can not create data source!", se);
    }

    Flyway flyway = Flyway.configure().dataSource(dataSource).load();

    flyway.clean();
    flyway.migrate();

    coronaDao = new CoronaDao(dataSource);

  }

  @Test
  void addCitizenToDatabase() {


//    coronaDao.addCitizenToDatabase(activity1);
//    coronaDao.addCitizenToDatabase(activity2);
  }

  @Test
  void insertGroupOfCitizens() {
  }

  @Test
  void vaccination() {
  }

  @Test
  void deleteVaccinationWithNotes() {
  }

  @Test
  void findCitizensWithGivenPostalCode() {
  }

  @Test
  void findTownWithTheGivenZip() {
  }

  @Test
  void searchForExistingTaj() {
  }

  @Test
  void searchCitizenAndVaccinationByTaj() {
  }

  @Test
  void giveRegisteredCitizensBack() {
  }
}