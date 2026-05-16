package repository;

import database.DBConnection;
import model.Budget;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BudgetRepository {

    public void save(Budget budget) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT OR REPLACE INTO budgets(category, limit_amount, spent) VALUES(?,?,?)")) {

            stmt.setString(1, budget.getCategory());
            stmt.setDouble(2, budget.getLimitAmount());
            stmt.setDouble(3, budget.getSpent());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addExpense(String category, double amount) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE budgets SET spent = spent + ? WHERE category = ?")) {

            stmt.setDouble(1, amount);
            stmt.setString(2, category);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Budget findByCategory(String category) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM budgets WHERE category=?")) {

            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Budget(rs.getString("category"),
                        rs.getDouble("limit_amount"),
                        rs.getDouble("spent"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Budget> getAll() {
        List<Budget> budgets = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM budgets")) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                budgets.add(new Budget(rs.getString("category"),
                        rs.getDouble("limit_amount"),
                        rs.getDouble("spent")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return budgets;
    }
}
