package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void init() {
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT, email TEXT UNIQUE, password TEXT, balance REAL)");

            stmt.execute("CREATE TABLE IF NOT EXISTS transactions ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "type TEXT, amount REAL, category TEXT)");

            stmt.execute("CREATE TABLE IF NOT EXISTS budgets ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "category TEXT UNIQUE, limit_amount REAL, spent REAL)");

            stmt.execute("CREATE TABLE IF NOT EXISTS goals ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT UNIQUE, target REAL, current REAL)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
