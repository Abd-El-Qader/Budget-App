package service;

import model.Budget;
import repository.BudgetRepository;

import java.util.List;

public class BudgetService {

    private BudgetRepository repo = new BudgetRepository();

    public void createBudget(String category, double limit) {
        if (category == null || category.isBlank() || limit <= 0) {
            System.out.println("Invalid budget data.");
            return;
        }

        repo.save(new Budget(category, limit));
    }

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

    public List<Budget> getAllBudgets() {
        return repo.getAll();
    }
}
