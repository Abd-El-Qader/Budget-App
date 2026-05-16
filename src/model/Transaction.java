package model;

<<<<<<< HEAD
public class Transaction {
    public enum Type { INCOME, EXPENSE }
=======
/**
 * Represents a financial transaction in the system.
 * A transaction can be either an INCOME or an EXPENSE.
 */
public class Transaction {

    public enum Type {
        INCOME, EXPENSE
    }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

    private Type type;
    private double amount;
    private String category;

<<<<<<< HEAD
    public Transaction(Type type, double amount, String category) {
=======
    /**
     * Constructs a new Transaction with the specified type, amount, and category.
     *
     * @param type the transaction type (INCOME or EXPENSE)
     * @param amount the transaction amount
     * @param category the transaction category
     */
    public Transaction(Type type, double amount, String category) {
        
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

<<<<<<< HEAD
    public Type getType() { return type; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
=======
    /**
     * Returns the type of this transaction.
     *
     * @return the transaction type (INCOME or EXPENSE)
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the amount of this transaction.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the category of this transaction.
     *
     * @return the transaction category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Converts this transaction into a Comma-Separated Values line for file storage.
     *
     * @return a string in the format: type,amount,category
     */
    public String toFileLine() {
        return type + "," + amount + "," + category;
    }

    /**
     * Creates a Transaction object from a Comma-Separated Values line.
     *
     * @param line a string in the format: type,amount,category
     * @return a Transaction object
     * @throws IllegalArgumentException if the line format is invalid
     */
    public static Transaction fromFileLine(String line) {
        String[] parts = line.split(",");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid transaction line: " + line);
        }
        Type type = Type.valueOf(parts[0].trim());
        double amount = Double.parseDouble(parts[1].trim());
        String category = parts[2].trim();

        return new Transaction(type, amount, category);
    }
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
}
