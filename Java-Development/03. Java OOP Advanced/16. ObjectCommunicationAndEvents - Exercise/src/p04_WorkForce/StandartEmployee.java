package p04_WorkForce;

public class StandartEmployee extends AbstractEmployee {
    private int workHoursPerWeek;


    public StandartEmployee(String name) {
        super(name);
        this.workHoursPerWeek = 40;
    }

    @Override
    public int getHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
