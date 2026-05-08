package repository;

import model.Budget;

import java.io.*;
import java.util.*;

/**
 * This class responsible for managing budget data.
 * It handles storing, retrieving, updating, and deleting budgets.
 */

public class BudgetRepository {
    private static final String FILE_NAME = "budgets.txt";

    /**
     * Saves a budget or updates it if it already exists.
     * 
     * @param budget the budget object to be saved or updated
     */
    public void save(Budget budget) {
        List<Budget> budgets = getAll();
        boolean updated = false;

        for (int i = 0; i < budgets.size(); i++) {
            if (budgets.get(i).getCategory().equalsIgnoreCase(budget.getCategory())) {
                budgets.set(i, budget);
                updated = true;
                break;
            }
        }

        if (!updated) {
            budgets.add(budget);
        }

        writeAll(budgets);
    }

    /**
     * Saves an added expense to a budget category.
     * 
     * @param category the category of the budget
     * @param amount   the expense amount to be saved
     */
    public void addExpense(String category, double amount) {
        List<Budget> budgets = getAll();

        for (Budget budget : budgets) {
            if (budget.getCategory().equalsIgnoreCase(category)) {
                budget.addExpense(amount);
            }
        }

        writeAll(budgets);
    }

    /**
     * Finds a budget by its category
     * 
     * @param category the category of the budget to search for
     * @return the matching budgt or null if not found
     */
    public Budget findByCategory(String category) {
        for (Budget budget : getAll()) {
            if (budget.getCategory().equalsIgnoreCase(category)) {
                return budget;
            }
        }

        return null;
    }

    /**
     * Retrieves all budgets from the file.
     *
     * @return list of all stored budgets or an empty list if file does not exist
     */
    public List<Budget> getAll() {
        List<Budget> budgets = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return budgets;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.trim().isEmpty()) {
                    budgets.add(Budget.fromFileLine(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return budgets;
    }

    /**
     * Writes all budgets to the file, replacing existing content.
     *
     * @param budgets the list of budgets to be saved
     */
    private void writeAll(List<Budget> budgets) {
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            for (Budget budget : budgets) {
                writer.write(budget.toFileLine() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}