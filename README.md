# Java Profile Management System (MVC + DAO)

A robust, console-based Java application designed to manage user profiles using a professional **Model-View-Controller (MVC)** architecture and the **Data Access Object (DAO)** pattern. This project integrates with a **MySQL** database to perform CRUD operations.

## 🚀 Key Features
* **User Management**: Add, view all, and search for user profiles by unique IDs.
* **Database Integration**: Full persistence using JDBC and MySQL.
* **Clean Architecture**: Complete separation of UI (View), Business Logic (Controller), and Database Logic (DAO).
* **Security**: Implemented `PreparedStatement` to prevent SQL Injection attacks.
* **Decoupled Design**: Uses Java Interfaces to ensure the system is modular and easy to extend.

## 🏗️ Project Structure
The project is organized into distinct packages to follow the "Separation of Concerns" principle:

* **`app`**: The entry point of the application.
* **`view`**: Handles all user interaction and console I/O.
* **`controller`**: Coordinates data between the View and the Data layer.
* **`dao`**: Contains the Data Access Object interface and its MySQL implementation.
* **`model`**: Defines the `User` entity (POJO).
* **`utils`**: Manages database connection strings and drivers.

## 🛠️ Technologies Used
* **Language**: Java (JDK 17+)
* **Database**: MySQL 8.0
* **Build Tool**: Maven
* **Library**: JDBC (Java Database Connectivity)

## 📋 Database Schema
To run this project locally, create a table named `profile` in your MySQL database:

```sql
CREATE TABLE profile (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);