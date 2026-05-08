package model;

/**
 * This class represents a user with name, email, password, and balance.
 */
public class User {

    private String name;
    private String email;
    private String password;
    private double balance;

    /**
     * Constructs a user with zero initial account balance.
     *
     * @param name     the user's name
     * @param email    the user's email
     * @param password the user's password
     */
    public User(String name, String email, String password) {
        this(name, email, password, 0);
    }

    /**
     * Constructs a user with a specified initial balance.
     *
     * @param name     the user's name
     * @param email    the user's email
     * @param password the user's password
     * @param balance  the user's initial balance
     */
    public User(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Returns the user's name.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's email.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's password.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the user's current balance.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Adds an amount to the user's balance.
     *
     * @param amount the amount to add
     */
    public void addBalance(double amount) {
        balance += amount;
    }

    /**
     * Subtracts an amount from the user's balance.
     *
     * @param amount the amount to subtract
     */
    public void subtractBalance(double amount) {
        balance -= amount;
    }

    /**
     * Converts this user to a CSV line for file storage.
     *
     * @return a string in the format: name,email,password,balance
     */
    public String toFileLine() {
        return name + "," + email + "," + password + "," + balance;
    }

    /**
     * Creates a User object from a CSV line.
     *
     * @param line a string in the format: name,email,password,balance
     * @return a User object
     */
    public static User fromFileLine(String line) {
        String[] parts = line.split(",");
        return new User(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}
