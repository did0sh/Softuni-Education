package p08_MilitaryElite;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return this.partName;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       sb.append(String.format("Part Name: %s Hours Worked: %d%n", this.getPartName(), this.getHoursWorked()));
       return sb.toString();
    }
}
