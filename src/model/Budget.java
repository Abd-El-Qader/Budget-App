package model;

/**
 * This class represents a budget for a specific category.
 * It tracks the spending limit, current expenses, and budget status.
 */
public class Budget {

    private String category;
    private double limitAmount;
    private double spent;

    /**
     * Constructs a Budget with a category, limit amount, and initial spent value.
     *
     * @param category the budget category 
     * @param limitAmount the maximum allowed spending
     * @param spent the initial amount already spent
     */
    public Budget(String category, double limitAmount, double spent) {
        this.category = category;
        this.limitAmount = limitAmount;
        this.spent = spent;
    }

    /**
     * Constructs a Budget with zero initial spending.
     *
     * @param category the budget category
     * @param limitAmount the maximum allowed spending
     */
    public Budget(String category, double limitAmount) {
        this(category, limitAmount, 0);
    }

    /**
     * Returns the budget category.
     *
     * @return category name
     */
    public String getCategory() { return category; }

    /**
     * Returns the spending limit
     *
     * @return limit amount
     */
    public double getLimitAmount() { return limitAmount; }

    /**
     * Returns the amount spent so far
     *
     * @return spent amount
     */
    public double getSpent() { return spent; }

    /**
     * Calculates the remaining budget.
     *
     * @return remaining amount (limit - spent)
     */
    public double getRemaining() { return limitAmount - spent; }

    /**
     * Adds an expense to the budget.
     *
     * @param amount the expense amount to add
     */
    public void addExpense(double amount) { spent += amount; }

    /**
     * Returns the current status of the budget.
     *
     * @return "Exceeded" if over limit,
     *         "Near Limit" if 75% or more used,
     *         otherwise "On Track"
     */
    public String getStatus() {
        if (spent >= limitAmount) return "Exceeded";
        if (spent >= limitAmount * 0.75) return "Near Limit";
        return "On Track";
    }

    /**
     * Converts the budget object to a string format for file storage.
     *
     * @return comma-separated string (category, limitAmount, spent)
     */
    public String toFileLine() {
        return category + "," + limitAmount + "," + spent;
    }

    /**
     * Creates a Budget object from a file line.
     *
     * @param line a comma-separated string representing a budget
     * @return Budget object created from the line
     */
    public static Budget fromFileLine(String line) {
        String[] parts = line.split(",");
        return new Budget(
            parts[0],
            Double.parseDouble(parts[1]),
            Double.parseDouble(parts[2])
        );
    }
}