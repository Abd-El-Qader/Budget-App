package repository;

<<<<<<< HEAD
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
=======
import model.Transaction;

import java.io.*;
import java.util.*;

/**
 * Repository class for Transaction entities.
 * Handles storing, retrieving the transactions
 */
public class TransactionRepository {
    private static final String FILE_NAME = "transactions.txt";

    /**
     * Save a specific transaction and stores it to the file
     * 
     * @param transaction transaction object to be saved
     */
    public void save(Transaction transaction) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(transaction.toFileLine() + System.lineSeparator());
        } catch (IOException e) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
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

=======
    /**
     * Retrieves all transaction from the file
     * 
     * @return list of all stored transactions or an empty list if the file does not exist
     */
    public List<Transaction> getAll() {
        List<Transaction> transactions = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return transactions;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.trim().isEmpty()) {
                    transactions.add(Transaction.fromFileLine(line));
                }
            }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        } catch (Exception e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
        return list;
=======
        return transactions;
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    }
}
