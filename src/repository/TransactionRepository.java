package repository;

import database.DBConnection;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public void save(Transaction t) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO transactions(type,amount,category) VALUES(?,?,?)")) {

            stmt.setString(1, t.getType().toString());
            stmt.setDouble(2, t.getAmount());
            stmt.setString(3, t.getCategory());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAll() {
        List<Transaction> list = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions");

            while (rs.next()) {
                list.add(new Transaction(
                        Transaction.Type.valueOf(rs.getString("type")),
                        rs.getDouble("amount"),
                        rs.getString("category")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
