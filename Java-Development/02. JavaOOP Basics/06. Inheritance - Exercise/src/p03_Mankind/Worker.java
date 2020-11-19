package p03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;


    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName,lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private double calcSalaryPerHour(){
        return this.weekSalary / (7 * this.workHoursPerDay);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", super.getFirstName()))
                .append(String.format("Last Name: %s%n", super.getLastName()))
                .append(String.format("Week salary: %.2f%n", this.getWeekSalary()))
                .append(String.format("Hours per day: %.2f%n", this.getWorkHoursPerDay()))
                .append(String.format("Salary per hour: %.2f%n", this.calcSalaryPerHour()));

        return sb.toString();
    }
}
