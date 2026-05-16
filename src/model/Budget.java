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

    public String getStatus() {
        if (spent >= limitAmount) return "Exceeded";
        if (spent >= limitAmount * 0.75) return "Near Limit";
        return "On Track";
    }
}
