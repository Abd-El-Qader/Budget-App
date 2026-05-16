package service;

import model.Transaction;
import model.User;
import repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository repo = new TransactionRepository();

    public void add(User user, Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        repo.save(transaction);

        if (transaction.getType() == Transaction.Type.INCOME) {
            user.addBalance(transaction.getAmount());
        } else {
            user.subtractBalance(transaction.getAmount());
        }
    }

    public List<Transaction> getAll() {
        return repo.getAll();
    }
}
