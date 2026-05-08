package repository;

import model.Transaction;

import java.io.*;
import java.util.*;

public class TransactionRepository {
    private static final String FILE_NAME = "transactions.txt";

    public void save(Transaction transaction) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(transaction.toFileLine() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
