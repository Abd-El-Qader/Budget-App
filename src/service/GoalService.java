package service;

import model.Goal;
import repository.GoalRepository;

import java.util.List;

/**
 * Service class responsible for goal operations and business logic
 */
public class GoalService {
    private GoalRepository repo = new GoalRepository();

    /**
     * Creates a new goal after validating the input data.
     * 
     * @param name   the goal name
     * @param target the target amount
     */
    public void createGoal(String name, double target) {
        if (name == null || name.isBlank() || target <= 0) {
            return;
        }

        repo.save(new Goal(name, target));
    }

    /**
     * Adds a saving amount to a specific goal.
     *
     * @param goalName the goal name
     * @param amount   the amount to be added
     */
    public void addSaving(String goalName, double amount) {
        if (amount <= 0) {
            return;
        }

        repo.addSaving(goalName, amount);
    }

    /**
     * Retrieves all stored goals.
     *
     * @return a list of all goals
     */
    public List<Goal> getAllGoals() {
        return repo.getAll();
    }
}
