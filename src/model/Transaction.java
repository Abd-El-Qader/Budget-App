package model;

public class Transaction {
    public enum Type { INCOME, EXPENSE }

    private Type type;
    private double amount;
    private String category;

    public Transaction(Type type, double amount, String category) {
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public Type getType() { return type; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    public String toFileLine() {
        return type + "," + amount + "," + category;
    }

    public static Transaction fromFileLine(String line) {
        String[] parts = line.split(",");
        return new Transaction(Type.valueOf(parts[0]), Double.parseDouble(parts[1]), parts[2]);
    }
}
