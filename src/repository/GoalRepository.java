package repository;

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return goals;
    }
}
