package ui;

<<<<<<< HEAD
import database.DatabaseInitializer;
=======
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
import model.Budget;
import model.Goal;
import model.Transaction;
import model.User;
import service.AuthService;
import service.BudgetService;
import service.GoalService;
import service.ReportService;
import service.TransactionService;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
public class MainFrame extends JFrame {

=======
/**
 * Main graphical user interface for the Personal Budgeting Software.
 * Handles user interaction and connects UI actions with system services.
 */

public class MainFrame extends JFrame {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private final AuthService authService = new AuthService();
    private final TransactionService transactionService = new TransactionService();
    private final BudgetService budgetService = new BudgetService();
    private final GoalService goalService = new GoalService();
    private final ReportService reportService = new ReportService();

    private User currentUser;
    private final JTextArea outputArea = new JTextArea();

<<<<<<< HEAD
    public MainFrame() {
        DatabaseInitializer.init();

=======
    /**
     * Creates and initializes the main application window.
     */
    public MainFrame() {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        setTitle("Personal Budgeting Software");
        setSize(720, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JPanel buttons = new JPanel(new GridLayout(4, 2, 8, 8));

        JButton signUpButton = new JButton("1. Sign Up");
        JButton loginButton = new JButton("2. Login");
        JButton transactionButton = new JButton("3. Add Transaction");
        JButton budgetButton = new JButton("4. Create Budget");
        JButton alertButton = new JButton("5. Track Budget Alert");
        JButton goalButton = new JButton("6. Set Financial Goal");
        JButton reportButton = new JButton("7. View Reports");
        JButton loadButton = new JButton("Load Saved Data");

        buttons.add(signUpButton);
        buttons.add(loginButton);
        buttons.add(transactionButton);
        buttons.add(budgetButton);
        buttons.add(alertButton);
        buttons.add(goalButton);
        buttons.add(reportButton);
        buttons.add(loadButton);

        add(buttons, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        signUpButton.addActionListener(e -> signUp());
        loginButton.addActionListener(e -> login());
        transactionButton.addActionListener(e -> addTransaction());
        budgetButton.addActionListener(e -> createBudget());
        alertButton.addActionListener(e -> trackBudgetAlert());
        goalButton.addActionListener(e -> createGoal());
        reportButton.addActionListener(e -> showReport());
        loadButton.addActionListener(e -> loadSavedData());
    }

<<<<<<< HEAD
=======
    /**
     * Checks if a user is logged in before accessing protected features.
     *
     * @return true if a user is logged in, otherwise false
     */

>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private boolean requireLogin() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "Please login first.");
            return false;
        }
<<<<<<< HEAD
        return true;
    }

=======

        return true;
    }

    /**
     * Handles user signup through dialog inputs.
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private void signUp() {
        String name = JOptionPane.showInputDialog(this, "Name:");
        String email = JOptionPane.showInputDialog(this, "Email:");
        String password = JOptionPane.showInputDialog(this, "Password:");

        User user = authService.signUp(name, email, password);

        if (user != null) {
            currentUser = user;
            outputArea.setText("Account created and logged in: " + user.getEmail());
        } else {
<<<<<<< HEAD
            outputArea.setText("Could not create account. Email may already exist.");
        }
    }

=======
            outputArea.setText("Could not create account. Email may already exist or data is invalid.");
        }
    }

    /**
     * Handles user login.
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private void login() {
        String email = JOptionPane.showInputDialog(this, "Email:");
        String password = JOptionPane.showInputDialog(this, "Password:");

        User user = authService.login(email, password);

        if (user != null) {
            currentUser = user;
            outputArea.setText("Logged in successfully: " + user.getEmail());
        } else {
            outputArea.setText("Invalid email or password.");
        }
    }

<<<<<<< HEAD
    private void addTransaction() {
        if (!requireLogin()) return;

        String[] types = {"INCOME", "EXPENSE"};
=======
    /**
     * Adds a new transaction for the logged-in user.
     */
    private void addTransaction() {
        if (!requireLogin())
            return;

        String[] types = { "INCOME", "EXPENSE" };
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        String selectedType = (String) JOptionPane.showInputDialog(
                this, "Transaction Type:", "Add Transaction",
                JOptionPane.QUESTION_MESSAGE, null, types, types[0]);

        String amountText = JOptionPane.showInputDialog(this, "Amount:");
        String category = JOptionPane.showInputDialog(this, "Category:");

        try {
            double amount = Double.parseDouble(amountText);
            Transaction.Type type = Transaction.Type.valueOf(selectedType);

            transactionService.add(currentUser, new Transaction(type, amount, category));

            if (type == Transaction.Type.EXPENSE) {
                String alert = budgetService.trackExpense(category, amount);
                outputArea.setText("Transaction saved.\n" + alert);
            } else {
                outputArea.setText("Income saved successfully.");
            }

<<<<<<< HEAD
        } catch (Exception ex) {
=======
        } catch (Exception e) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            outputArea.setText("Invalid transaction data.");
        }
    }

<<<<<<< HEAD
    private void createBudget() {
        if (!requireLogin()) return;
=======
    /**
     * Creates a new budget.
     */
    private void createBudget() {
        if (!requireLogin())
            return;
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

        String category = JOptionPane.showInputDialog(this, "Budget Category:");
        String limitText = JOptionPane.showInputDialog(this, "Budget Limit:");

        try {
            double limit = Double.parseDouble(limitText);
            budgetService.createBudget(category, limit);
            outputArea.setText("Budget created for " + category);
<<<<<<< HEAD
        } catch (Exception ex) {
=======
        } catch (Exception e) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            outputArea.setText("Invalid budget data.");
        }
    }

<<<<<<< HEAD
    private void trackBudgetAlert() {
        if (!requireLogin()) return;
=======
    /**
     * Displays all budgets and their current status.
     */
    private void trackBudgetAlert() {
        if (!requireLogin())
            return;
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

        StringBuilder text = new StringBuilder("===== BUDGETS =====\n");

        for (Budget budget : budgetService.getAllBudgets()) {
            text.append("Category: ").append(budget.getCategory()).append("\n");
            text.append("Limit: ").append(budget.getLimitAmount()).append("\n");
            text.append("Spent: ").append(budget.getSpent()).append("\n");
            text.append("Remaining: ").append(budget.getRemaining()).append("\n");
            text.append("Status: ").append(budget.getStatus()).append("\n");
            text.append("------------------\n");
        }

        outputArea.setText(text.toString());
    }

<<<<<<< HEAD
    private void createGoal() {
        if (!requireLogin()) return;
=======
    /**
     * Creates a new financial goal.
     */
    private void createGoal() {
        if (!requireLogin())
            return;
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

        String name = JOptionPane.showInputDialog(this, "Goal Name:");
        String targetText = JOptionPane.showInputDialog(this, "Target Amount:");

        try {
            double target = Double.parseDouble(targetText);
            goalService.createGoal(name, target);
            outputArea.setText("Goal created: " + name);
<<<<<<< HEAD
        } catch (Exception ex) {
=======
        } catch (Exception e) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            outputArea.setText("Invalid goal data.");
        }
    }

<<<<<<< HEAD
    private void showReport() {
        if (!requireLogin()) return;
=======
    /**
     * Generates and displays the financial report.
     */
    private void showReport() {
        if (!requireLogin())
            return;
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

        outputArea.setText(reportService.generate(transactionService.getAll()));
    }

<<<<<<< HEAD
=======
    /**
     * Loads and displays saved transactions, budgets, and goals.
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private void loadSavedData() {
        StringBuilder text = new StringBuilder();

        text.append("===== SAVED TRANSACTIONS =====\n");
        for (Transaction transaction : transactionService.getAll()) {
            text.append(transaction.getType()).append(" | ")
                    .append(transaction.getAmount()).append(" | ")
                    .append(transaction.getCategory()).append("\n");
        }

        text.append("\n===== SAVED BUDGETS =====\n");
        for (Budget budget : budgetService.getAllBudgets()) {
            text.append(budget.getCategory()).append(" | Limit: ")
                    .append(budget.getLimitAmount()).append(" | Spent: ")
                    .append(budget.getSpent()).append(" | Status: ")
                    .append(budget.getStatus()).append("\n");
        }

        text.append("\n===== SAVED GOALS =====\n");
        for (Goal goal : goalService.getAllGoals()) {
            text.append(goal.getName()).append(" | Target: ")
                    .append(goal.getTarget()).append(" | Current: ")
                    .append(goal.getCurrent()).append(" | Progress: ")
                    .append(goal.getProgress()).append("%").append("\n");
        }

        outputArea.setText(text.toString());
    }
}
