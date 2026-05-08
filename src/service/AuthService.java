package service;

import model.User;
import repository.UserRepository;

public class AuthService {
    private UserRepository repo = new UserRepository();

    public User signUp(String name, String email, String password) {
        if (name == null || name.isBlank() || email == null || email.isBlank() || password == null || password.isBlank()) {
            return null;
        }

        User user = new User(name, email, password);

        if (repo.save(user)) {
            return user;
        }

        return null;
    }

    public User login(String email, String password) {
        User user = repo.find(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
