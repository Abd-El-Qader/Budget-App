package repository;

<<<<<<< HEAD
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
=======
import model.User;

import java.io.*;
import java.util.*;

/**
 * Repository class for User entities.
 * Handles storing, retrieving the Users
 */
public class UserRepository {
    private static final String FILE_NAME = "users.txt";

    /**
     * Saves a user if the email not already registered
     * 
     * @param user the user to be saved
     * @return true if the user saved successfully or false if the email already
     *         exists
     */
    public boolean save(User user) {
        if (find(user.getEmail()) != null) {
            return false;
        }

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(user.toFileLine() + System.lineSeparator());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            return false;
        }
    }

<<<<<<< HEAD
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

=======
    /**
     * Finds a user by email.
     *
     * @param email the email to search for
     * @return the matching user or null if not found
     */
    public User find(String email) {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return null;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                User user = User.fromFileLine(line);

                if (user.getEmail().equalsIgnoreCase(email)) {
                    return user;
                }
            }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
