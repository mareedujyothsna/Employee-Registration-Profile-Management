# Registration & Profile Management System

A console-based Employee Registration and Profile Management System developed using Core Java, JDBC, and Oracle Database.

## 📌 Overview

This project was developed as a hands-on Java and JDBC practice project to understand how a Java application interacts with an Oracle relational database.

The application allows employees to register, log in, view their profile, and update selected profile information.

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- Oracle Database
- SQL
- PL/SQL

## ✨ Features

- Employee Registration
- Employee Login using Employee ID and Password
- View Employee Profile
- Update Employee Address
- Update Employee Phone Number
- Oracle Database Connectivity using JDBC
- Stored Procedures using PL/SQL
- PreparedStatement for SQL operations
- CallableStatement for Stored Procedure execution
- Exception Handling
- Menu-driven console interface
- Controlled application exit

## 🔄 Application Flow

1. Employee selects whether they are already registered.
2. New users can register by providing employee details.
3. Registered users can log in using Employee ID and Password.
4. After login, users can:
   - View Profile
   - Update Profile
   - Exit the application

## 📂 Project Structure

```text

🗄️ Database

The application uses Oracle Database to store employee registration and profile information.

The project uses:

SQL queries
PL/SQL Stored Procedures
JDBC
PreparedStatement
CallableStatement
🔐 Security Note

Database credentials are not included in this repository.

Replace the database password placeholder in the source code with your own local Oracle credentials when running the application.

▶️ How to Run
Install Java JDK.
Install and configure Oracle Database.
Add the Oracle JDBC driver to your Java project.
Create the required employee table in Oracle.
Create the required PL/SQL stored procedures.
Update the database connection details in JdbcPro12.java.
Compile and run the Java application.

📚 Learning Outcomes
Through this project, I gained practical experience in:

Core Java programming
JDBC database connectivity
SQL and PL/SQL
Stored Procedure integration
PreparedStatement and CallableStatement
Exception handling
Database-driven application development
Menu-driven application design

 Developer
Jyothsna Mareedu
GitHub: https://github.com/mareedujyothsna
