package coronaproject;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
@PropertySource("classpath:/corona/corona.properties")
public class AppConfig {

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    MariaDbDataSource dataSource = new MariaDbDataSource();
    try {
      dataSource.setUrl(environment.getProperty("jdbc.url"));
      dataSource.setUser(environment.getProperty("jdbc.username"));
      dataSource.setPassword(environment.getProperty("jdbc.passwd"));
    }
    catch (SQLException sqle) {
      throw new IllegalStateException("Can not connect database!", sqle);
    }
    return dataSource;
  }
}
