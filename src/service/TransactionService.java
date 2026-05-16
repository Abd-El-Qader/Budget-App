package service;
<<<<<<< HEAD

import model.Transaction;
import model.User;
import repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository repo = new TransactionRepository();

    public void add(User user, Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            System.out.println("Amount must be positive.");
=======
import model.Transaction;
import model.User;
import repository.TransactionRepository;
import java.util.List;

/**
 * Service class responsible for transactions operations and business logic
 */
public class TransactionService {
    private TransactionRepository repo = new TransactionRepository();
}
    /**
     * Adds a transaction and updates the user's balance.
     *
     * @param user the user associated with the transaction
     * @param transaction the transaction to be added
     */
    public void add(User user, Transaction transaction) {
        if (transaction.getAmount() <= 0) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            return;
        }

        repo.save(transaction);

        if (transaction.getType() == Transaction.Type.INCOME) {
            user.addBalance(transaction.getAmount());
        } else {
            user.subtractBalance(transaction.getAmount());
        }
    }

<<<<<<< HEAD
=======
    /**
     * Retrieves all stored transactions.
     *
     * @return a list of all transactions
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    public List<Transaction> getAll() {
        return repo.getAll();
    }
}
