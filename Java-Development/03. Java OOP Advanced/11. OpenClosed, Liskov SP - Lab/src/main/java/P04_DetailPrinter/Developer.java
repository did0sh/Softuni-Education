package P04_DetailPrinter;

public class Developer extends Employee {
    private Iterable<String> tasks;
    public Developer(String name, Iterable<String> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Tasks: %s%n", String.join(", ", this.tasks)));
        return sb.toString();
    }
}
