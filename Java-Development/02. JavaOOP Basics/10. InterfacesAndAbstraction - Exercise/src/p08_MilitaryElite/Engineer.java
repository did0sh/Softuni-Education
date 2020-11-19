package p08_MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Engineer extends SpecialisedSoldier {
    private LinkedHashSet<Repair> repairs;
    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", super.getFirstName(),
                super.getLastName(), super.getId(), super.getSalary()));
        sb.append(String.format("Corps: %s%n", this.getCorps()));

        sb.append("Repairs:").append(System.lineSeparator());

        this.repairs.forEach(sb::append);
        return sb.toString();
    }
}
