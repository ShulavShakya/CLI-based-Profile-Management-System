package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/user";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}