package p04_WorkForce;

public class Job {
    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
    }

    public String getName() {
        return this.name;
    }

    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }

    public void update(){
        this.hoursOfWorkRequired -= this.employee.getHoursPerWeek();
        if (this.hoursOfWorkRequired <= 0){
            System.out.printf("Job %s done!%n", this.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Job: %s Hours Remaining: %d%n", this.getName(), this.getHoursOfWorkRequired()));
        return sb.toString();
    }
}

