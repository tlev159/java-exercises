package architecture;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot insert");
        }
    }

    public List<String> listEmployeeNames() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees")
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
            return names;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

    public String findEmployeeNameById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?");
        ) {
            ps.setLong(1, id);

            return selectNameByPreparedStatement(ps);
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                return name;
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }
}
