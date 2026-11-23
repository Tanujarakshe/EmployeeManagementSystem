
package com.employee.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees "
                + "(name, email, department, salary) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());

            statement.executeUpdate();

            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding employee!");
            e.printStackTrace();
        }
    }
 // Search Employee by ID
    public void searchEmployeeById(int id) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {

                    System.out.println("Employee Found!");
                    System.out.println("ID: " + result.getInt("id"));
                    System.out.println("Name: " + result.getString("name"));
                    System.out.println("Email: " + result.getString("email"));
                    System.out.println("Department: " + result.getString("department"));
                    System.out.println("Salary: " + result.getDouble("salary"));

                } else {
                    System.out.println("Employee not found!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching employee!");
            e.printStackTrace();
        }
    }
    // Update Employee
    public void updateEmployee(int id, String name,
                               String email, String department,
                               double salary) {

        String sql = "UPDATE employees SET name = ?, email = ?, "
                   + "department = ?, salary = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, department);
            statement.setDouble(4, salary);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee ID not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating employee!");
            e.printStackTrace();
        }
    }

 // Delete Employee
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee ID not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee!");
            e.printStackTrace();
        }
    }
    // View All Employees
    public void viewEmployees() {

        String sql = "SELECT * FROM employees";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("Department: "
                        + result.getString("department"));
                System.out.println("Salary: "
                        + result.getDouble("salary"));

                System.out.println("-----------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing employees!");
            e.printStackTrace();
        }
    }
}
