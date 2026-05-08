package model;

public class Goal {
    private String name;
    private double target;
    private double current;

    public Goal(String name, double target, double current) {
        this.name = name;
        this.target = target;
        this.current = current;
    }

    public Goal(String name, double target) {
        this(name, target, 0);
    }

    public String getName() { return name; }
    public double getTarget() { return target; }
    public double getCurrent() { return current; }

    public void addSaving(double amount) { current += amount; }

    public double getProgress() {
        if (target == 0) return 0;
        return (current / target) * 100;
    }

    public String getStatus() {
        return current >= target ? "Completed" : "In Progress";
    }

    public String toFileLine() {
        return name + "," + target + "," + current;
    }

    public static Goal fromFileLine(String line) {
        String[] parts = line.split(",");
        return new Goal(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
    }
}
