package service;

import model.User;
import repository.UserRepository;

/**
 * Service class responsible for user authentication operations
 */
public class AuthService {
    private UserRepository repo = new UserRepository();
    /**
     * register a new user after validating the input data
     * 
     * @param name the user's name
     * @param email the user's email
     * @param password the user's password
     * @return the created user if signed up or null
     */
    public User signUp(String name, String email, String password) {
        if (name == null || name.isBlank() || email == null || email.isBlank() || password == null
                || password.isBlank()) {
            return null;
        }

        User user = new User(name, email, password);

        if (repo.save(user)) {
            return user;
        }

        return null;
    }
    /**
     * Authenticates a user using email and password.
     * 
     * @param email the user's email
     * @param password the user's password 
     * @return the user if logged in successfully
     */
    public User login(String email, String password) {
        User user = repo.find(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
