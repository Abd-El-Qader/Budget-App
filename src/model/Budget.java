package model;

public class Budget {
    private String category;
    private double limitAmount;
    private double spent;

    public Budget(String category, double limitAmount, double spent) {
        this.category = category;
        this.limitAmount = limitAmount;
        this.spent = spent;
    }

    public Budget(String category, double limitAmount) {
        this(category, limitAmount, 0);
    }

    public String getCategory() { return category; }
    public double getLimitAmount() { return limitAmount; }
    public double getSpent() { return spent; }
    public double getRemaining() { return limitAmount - spent; }

    public void addExpense(double amount) { spent += amount; }

    public String getStatus() {
        if (spent >= limitAmount) return "Exceeded";
        if (spent >= limitAmount * 0.75) return "Near Limit";
        return "On Track";
    }

    public String toFileLine() {
        return category + "," + limitAmount + "," + spent;
    }

    public static Budget fromFileLine(String line) {
        String[] parts = line.split(",");
        return new Budget(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }
}
