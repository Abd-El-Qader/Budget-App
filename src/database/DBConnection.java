package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:budget.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
