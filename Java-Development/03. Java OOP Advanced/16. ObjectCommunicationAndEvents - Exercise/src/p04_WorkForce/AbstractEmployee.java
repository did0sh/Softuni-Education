package p04_WorkForce;

public abstract class AbstractEmployee implements Employee {
    private String name;
    private int hoursPerWeek;

    AbstractEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public abstract int getHoursPerWeek();

}
