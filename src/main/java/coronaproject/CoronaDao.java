package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoronaDao {

  private MariaDbDataSource dataSource;

  public CoronaDao(MariaDbDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void addCitizenToDatabase(Citizens citizen) {
//    try (Connection conn = dataSource.getConnection();
//         PreparedStatement stmt = conn.prepareStatement("INSERT INTO citizens");
//    );

  }


  public String findTownWithTheGivenZip(int zip) {
    String result = "";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT city FROM iranyitoszamok WHERE city_id = ?");
    ) {
      stmt.setLong(1, zip);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
              result = rs.getString("city");
         }

       } catch (SQLException se) {
       throw new IllegalStateException("Can not find town!", se);
     }

    } catch (SQLException se) {
      throw new IllegalStateException("Can not connect to database!" ,se);
    }
    return result;
  }

}
