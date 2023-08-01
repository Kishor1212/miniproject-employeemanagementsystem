
package employeemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDAO implements EmployeeDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "thalakishor";

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "thalakishor");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name1");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                Employee employee = new Employee(id, name1, position, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "thalakishor");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?")) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name1 = rs.getString("name1");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                employee = new Employee(id, name1, position, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management","root", "thalakishor");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (id, name1, position, salary) VALUES (?, ?, ?, ?)")) {

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName1());
            stmt.setString(3, employee.getPosition());
            stmt.setDouble(4, employee.getSalary());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management","root", "thalakishor");
             PreparedStatement stmt = conn.prepareStatement("UPDATE employees SET name1 = ?, position = ?, salary = ? WHERE id = ?")) {

            stmt.setString(1, employee.getName1());
            stmt.setString(2, employee.getPosition());
            stmt.setDouble(3, employee.getSalary());
            stmt.setInt(4, employee.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "thalakishor");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM employees WHERE id = ?")) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
