package repository;

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goals;
    }

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
}
