package repository;

import model.Budget;

import java.io.*;
import java.util.*;

public class BudgetRepository {
    private static final String FILE_NAME = "budgets.txt";

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

    public void addExpense(String category, double amount) {
        List<Budget> budgets = getAll();

        for (Budget budget : budgets) {
            if (budget.getCategory().equalsIgnoreCase(category)) {
                budget.addExpense(amount);
            }
        }

        writeAll(budgets);
    }

    public Budget findByCategory(String category) {
        for (Budget budget : getAll()) {
            if (budget.getCategory().equalsIgnoreCase(category)) {
                return budget;
            }
        }

        return null;
    }

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
