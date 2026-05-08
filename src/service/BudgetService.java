package service;

import model.Budget;
import repository.BudgetRepository;

import java.util.List;

/**
 * Service class responsible for budget operations
 * 
 */
public class BudgetService {
    private BudgetRepository repo = new BudgetRepository();

    /**
     * Creates a new budget after validating the input data.
     *
     * @param category the budget category
     * @param limit    the maximum allowed budget amount
     */
    public void createBudget(String category, double limit) {
        if (category == null || category.isBlank() || limit <= 0) {
            return;
        }

        repo.save(new Budget(category, limit));
    }

    /**
     * Adds an expense to a budget and returns its current status.
     *
     * @param category the budget category
     * @param amount   the expense amount
     * @return a message describing the budget status
     */
    public String trackExpense(String category, double amount) {
        repo.addExpense(category, amount);
        Budget budget = repo.findByCategory(category);

        if (budget == null) {
            return "No budget found for " + category;
        }

        if (budget.getStatus().equals("Exceeded")) {
            return "Budget Exceeded for " + category;
        }

        if (budget.getStatus().equals("Near Limit")) {
            return "Budget Near Limit for " + category;
        }

        return "Budget On Track for " + category;
    }

    /**
     * Retrieves all stored budgets.
     *
     * @return a list of all budgets
     */
    public List<Budget> getAllBudgets() {
        return repo.getAll();
    }
}
