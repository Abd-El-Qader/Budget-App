package model;

<<<<<<< HEAD
public class Goal {
=======
/**
 * This class represents a financial goal to be achieved.
 * It tracks the target amount and the current saved money.
 */
public class Goal {

>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    private String name;
    private double target;
    private double current;

<<<<<<< HEAD
=======
    /**
     * Constructs a Goal with a name, target amount, and current saved amount.
     *
     * @param name the name of the goal
     * @param target the target amount to be achieved
     * @param current the current saved amount
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    public Goal(String name, double target, double current) {
        this.name = name;
        this.target = target;
        this.current = current;
    }

<<<<<<< HEAD
=======
    /**
     * Constructs a Goal with zero initial saved amount.
     *
     * @param name the name of the goal
     * @param target the target amount to be achieved
     */
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
    public Goal(String name, double target) {
        this(name, target, 0);
    }

<<<<<<< HEAD
    public String getName() { return name; }
    public double getTarget() { return target; }
    public double getCurrent() { return current; }

    public double getProgress() {
        if (target == 0) return 0;
        return (current / target) * 100;
    }

    public String getStatus() {
        return current >= target ? "Completed" : "In Progress";
    }
}
=======
    /**
     * Returns the goal name.
     *
     * @return the goal name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the target amount to be achieved.
     *
     * @return the target amount
     */
    public double getTarget() {
        return target;
    }

    /**
     * Returns the current saved amount.
     *
     * @return the current saved amount
     */
    public double getCurrent() {
        return current;
    }

    /**
     * Adds an amount to the current saved amount.
     *
     * @param amount the amount to add
     */
    public void addSaving(double amount) {
        current += amount;
    }

    /**
     * Calculates the progress percentage towards the goal.
     *
     * @return the progress percentage 
     */
    public double getProgress() {
        if (target == 0) {
            return 0;
        }
        return (current / target) * 100;
    }

    /**
     * Returns the current status of the goal.
     *
     * @return "Completed" if the target is reached, otherwise "In Progress"
     */
    public String getStatus() {
        return current >= target ? "Completed" : "In Progress";
    }

    /**
     * Converts the goal data into a string format for file storage.
     *
     * @return a comma-separated string (name, target, current)
     */
    public String toFileLine() {
        return name + "," + target + "," + current;
    }

    /**
     * Creates a Goal object from a formatted file line.
     *
     * @param line a comma-separated string representing a goal
     * @return a Goal object created from the given line
     */
    public static Goal fromFileLine(String line) {
        String[] parts = line.split(",");
        return new Goal(
            parts[0],
            Double.parseDouble(parts[1]),
            Double.parseDouble(parts[2])
        );
    }
}
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
