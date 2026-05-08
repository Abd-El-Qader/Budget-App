package service;

import model.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class responsible for generating financial reports.
 */
public class ReportService {
    /**
     * Generates a financial report based on a list of transactions.
     *
     * @param transactions the list of transactions to analyze
     * @return a formatted financial report as a string
     */
    public String generate(List<Transaction> transactions) {
        double income = 0;
        double expense = 0;
        Map<String, Double> categoryTotals = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType() == Transaction.Type.INCOME) {
                income += transaction.getAmount();
            } else {
                expense += transaction.getAmount();
                categoryTotals.put(transaction.getCategory(),
                        categoryTotals.getOrDefault(transaction.getCategory(), 0.0) + transaction.getAmount());
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("===== FINANCIAL REPORT =====\n");
        report.append("Income: ").append(income).append("\n");
        report.append("Expense: ").append(expense).append("\n");
        report.append("Balance: ").append(income - expense).append("\n\n");
        report.append("Expense by Category:\n");

        for (String category : categoryTotals.keySet()) {
            report.append(category).append(": ").append(categoryTotals.get(category)).append("\n");
        }

        return report.toString();
    }
}
