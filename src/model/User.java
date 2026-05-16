package model;

public class User {
    private String name;
    private String email;
    private String password;
    private double balance;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    public void addBalance(double amount) { balance += amount; }
    public void subtractBalance(double amount) { balance -= amount; }
}
