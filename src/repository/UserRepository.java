package repository;

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
            return false;
        }
    }

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
