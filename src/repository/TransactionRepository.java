package repository;

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
            e.printStackTrace();
        }
    }

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
