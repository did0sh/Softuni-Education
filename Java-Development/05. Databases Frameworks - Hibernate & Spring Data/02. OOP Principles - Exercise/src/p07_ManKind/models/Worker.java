package p07_ManKind.models;

public class Worker extends Human {
    private double weekSalary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    @Override
    public void setLastName(String lastName) {
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

    private void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = hoursPerDay;
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public double getHoursPerDay() {
        return this.hoursPerDay;
    }

    private double getSalaryPerHour(){
        return (this.weekSalary / (7 * this.hoursPerDay));
    }

    @Override
    public String toString() {
        return String.format("%s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                super.toString(),this.getWeekSalary(), this.getHoursPerDay(), this.getSalaryPerHour());
    }
}
