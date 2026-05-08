package repository;

import model.User;

import java.io.*;
import java.util.*;

public class UserRepository {
    private static final String FILE_NAME = "users.txt";

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
