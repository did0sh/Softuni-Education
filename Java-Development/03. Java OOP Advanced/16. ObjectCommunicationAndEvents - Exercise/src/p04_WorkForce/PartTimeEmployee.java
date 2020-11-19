package p04_WorkForce;

public class PartTimeEmployee extends AbstractEmployee {
    private int workHoursPerWeek;

    public PartTimeEmployee(String name) {
        super(name);
        this.workHoursPerWeek = 20;
    }

    @Override
    public int getHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
