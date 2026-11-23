
package com.employee.management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Check environment variable
        if (System.getenv("DB_PASSWORD") == null
                || System.getenv("DB_PASSWORD").isEmpty()) {

            System.out.println("DB_PASSWORD NOT RECEIVED");
            System.out.println("Please configure the Windows environment variable.");
            return;

        } else {
            System.out.println("DB_PASSWORD RECEIVED");
        }

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = 0;
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(sc.nextLine());

                    Employee employee = new Employee(
                            0, name, email, department, salary);

                    dao.addEmployee(employee);
                    break;

                case 2:
                    System.out.println("\n===== ALL EMPLOYEES =====");
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    dao.searchEmployeeById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = Double.parseDouble(sc.nextLine());

                    dao.updateEmployee(
                            updateId,
                            newName,
                            newEmail,
                            newDepartment,
                            newSalary
                    );
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    dao.deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
