package p07_1984.models;

public class Employee extends Entity {

    private int income;

    public Employee(String id, String name, int income) {
        super(id, name);
        this.income = income;
    }
}