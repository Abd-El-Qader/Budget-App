package model;

public class User {
    private String name;
    private String email;
    private String password;
    private double balance;

    public User(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public User(String name, String email, String password) {
        this(name, email, password, 0);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    public void addBalance(double amount) { balance += amount; }
    public void subtractBalance(double amount) { balance -= amount; }

    public String toFileLine() {
        return name + "," + email + "," + password + "," + balance;
    }

    public static User fromFileLine(String line) {
        String[] parts = line.split(",");
        return new User(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}
