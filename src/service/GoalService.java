package service;

import model.Goal;
import repository.GoalRepository;

import java.util.List;

public class GoalService {
    private GoalRepository repo = new GoalRepository();

    public void createGoal(String name, double target) {
        if (name == null || name.isBlank() || target <= 0) {
            return;
        }

        repo.save(new Goal(name, target));
    }

    public void addSaving(String goalName, double amount) {
        if (amount <= 0) {
            return;
        }

        repo.addSaving(goalName, amount);
    }

    public List<Goal> getAllGoals() {
        return repo.getAll();
    }
}
