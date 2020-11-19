package P04_DetailPrinter;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s%n", this.getName()));
        return sb.toString();
    }
}
