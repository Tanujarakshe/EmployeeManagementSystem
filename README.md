
# Employee Management System

A Java-based Employee Management System that performs CRUD (Create, Read, Update, Delete) operations using JDBC and MySQL.

## Project Overview

This project helps manage employee information through a menu-driven console application.

## Features

- Add new employees
- View all employees
- Search employees by ID
- Update employee details
- Delete employee records
- MySQL database connectivity
- Secure database password using environment variables

## Technologies Used

- Java
- JDBC
- MySQL
- MySQL Connector/J
- Eclipse IDE

## Database Setup

Create a MySQL database:

    CREATE DATABASE employee_management;

Select the database:

    USE employee_management;

Create the employees table:

    CREATE TABLE employees (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        department VARCHAR(50),
        salary DECIMAL(10,2)
    );

## Configuration

Set a Windows environment variable:

    DB_PASSWORD=your_mysql_password

Update the database username and URL in DBConnection.java if needed.

Add MySQL Connector/J to the Eclipse project Classpath.

## How to Run

1. Clone or download this repository.
2. Open the project in Eclipse.
3. Configure MySQL and the DB_PASSWORD environment variable.
4. Add MySQL Connector/J to the Classpath.
5. Run Main.java.

## Project Structure

    EmployeeManagementSystem
    |
    |-- src
    |   |-- com.employee.management
    |       |-- Employee.java
    |       |-- DBConnection.java
    |       |-- EmployeeDAO.java
    |       |-- Main.java
    |       |-- TestConnection.java
    |
    |-- .gitignore
    |-- README.md

## Learning Outcomes

- Java object-oriented programming
- JDBC database connectivity
- SQL CRUD operations
- PreparedStatement usage
- Exception handling
- MySQL integration

## Author

Java Developer Fresher
