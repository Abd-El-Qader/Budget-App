package service;

import model.Goal;
import repository.GoalRepository;

import java.util.List;

<<<<<<< HEAD
public class GoalService {

    private GoalRepository repo = new GoalRepository();

    public void createGoal(String name, double target) {
        if (name == null || name.isBlank() || target <= 0) {
            System.out.println("Invalid goal data.");
=======
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
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            return;
        }

        repo.save(new Goal(name, target));
    }

<<<<<<< HEAD
    public void addSaving(String goalName, double amount) {
        if (amount <= 0) {
            System.out.println("Saving amount must be positive.");
=======
    /**
     * Adds a saving amount to a specific goal.
     *
     * @param goalName the goal name
     * @param amount   the amount to be added
     */
    public void addSaving(String goalName, double amount) {
        if (amount <= 0) {
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
            return;
        }

        repo.addSaving(goalName, amount);
    }

<<<<<<< HEAD
=======
    /**
     * Retrieves all stored goals.
     *
     * @return a list of all goals
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    public List<Goal> getAllGoals() {
        return repo.getAll();
    }
}
