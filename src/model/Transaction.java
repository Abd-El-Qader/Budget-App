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
}
