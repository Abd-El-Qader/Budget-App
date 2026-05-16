package repository;

<<<<<<< HEAD
import database.DBConnection;
import model.Goal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoalRepository {

    public void save(Goal goal) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT OR REPLACE INTO goals(name, target, current) VALUES(?,?,?)")) {

            stmt.setString(1, goal.getName());
            stmt.setDouble(2, goal.getTarget());
            stmt.setDouble(3, goal.getCurrent());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSaving(String goalName, double amount) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE goals SET current = current + ? WHERE name = ?")) {

            stmt.setDouble(1, amount);
            stmt.setString(2, goalName);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Goal> getAll() {
        List<Goal> goals = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM goals")) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                goals.add(new Goal(rs.getString("name"),
                        rs.getDouble("target"),
                        rs.getDouble("current")));
            }

=======
import model.Goal;

import java.io.*;
import java.util.*;

/**
 * Repository class for Goal entities.
 * Handles storing, retrieving, and updating goals
 */
public class GoalRepository {
    private static final String FILE_NAME = "goals.txt";

    /**
     * Saves a goal or updates it if it already exists.
     * 
     * @param goal the goal object to be saved or updated
     */
    public void save(Goal goal) {
        List<Goal> goals = getAll();
        boolean updated = false;

        for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i).getName().equalsIgnoreCase(goal.getName())) {
                goals.set(i, goal);
                updated = true;
                break;
            }
        }

        if (!updated) {
            goals.add(goal);
        }

        writeAll(goals);
    }

    /**
     * Add an amount to a specific goal
     * 
     * @param goalName the name of the goal
     * @param amount   the amount to be added
     */
    public void addSaving(String goalName, double amount) {
        List<Goal> goals = getAll();

        for (Goal goal : goals) {
            if (goal.getName().equalsIgnoreCase(goalName)) {
                goal.addSaving(amount);
                break;
            }
        }

        writeAll(goals);
    }

    /**
     * Retrieve all goals from the file
     * 
     * @return list of all stored goals or an empty list if file does not exist
     */
    public List<Goal> getAll() {
        List<Goal> goals = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return goals;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.trim().isEmpty()) {
                    goals.add(Goal.fromFileLine(line));
                }
            }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goals;
    }
<<<<<<< HEAD
=======

    /**
     * Writes all goals to the file and repalcing the existing content.
     * 
     * @param goals
     */
    private void writeAll(List<Goal> goals) {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            for (Goal goal : goals) {
                writer.write(goal.toFileLine() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
}
