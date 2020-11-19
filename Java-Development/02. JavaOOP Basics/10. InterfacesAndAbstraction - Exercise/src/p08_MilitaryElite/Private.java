package p08_MilitaryElite;

public class Private implements Soldier {
    private String id;
    private String firstName;
    private String lastName;
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", this.getFirstName(),
                this.getLastName(), this.getId(), this.getSalary()));
        return sb.toString();
    }
}
