package repository;

import database.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    public boolean save(User u) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO users(name,email,password,balance) VALUES(?,?,?,?)")) {

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setDouble(4, u.getBalance());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public User find(String email) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE email=?")) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
