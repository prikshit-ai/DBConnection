# Student Data Entry System

A Java-based application for managing student records using MySQL database. The system supports basic CRUD (Create, Read, Update, Delete) operations for student data, which includes attributes such as PRN (unique student identifier), Name, Branch, Batch, and CGPA.

## Features

- **Add Student**: Add new student records.
- **Display All Students**: View all stored student records.
- **Search by PRN**: Search for a student based on PRN.
- **Update Student**: Update details of an existing student.
- **Delete Student**: Remove a student record by PRN.

## Prerequisites

Before running the program, ensure you have the following installed:

- **Java**: Version 8 or above.
- **MySQL**: A running MySQL server instance.
- **MySQL JDBC Connector**: `mysql-connector-j-9.2.0.jar`.
File Structure

|-- DBConnection.java        // Database connection handler
|-- Main.java                 // Menu-driven user interface
|-- Student.java              // Student entity class
|-- StudentOperations.java    // CRUD operations for students
|-- mysql-connector-j-9.2.0.jar // MySQL JDBC driver
