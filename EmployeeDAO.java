import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public void addEmployee(String name, String department, double salary) throws SQLException {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        }
    }

    public void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("department") + " | " +
                                   rs.getDouble("salary"));
            }
        }
    }

    public void updateEmployee(int id, String name, String department, double salary) throws SQLException {
        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Employee updated successfully.");
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
             }
            }
        }
