package p08_MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Commando extends SpecialisedSoldier {
    private LinkedHashSet<Mission> missions;
    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    public void addMission(Mission mission){
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", super.getFirstName(),
                super.getLastName(), super.getId(), super.getSalary()));
        sb.append(String.format("Corps: %s%n", this.getCorps()));

        sb.append("Missions:").append(System.lineSeparator());

        this.missions.forEach(sb::append);
        return sb.toString();
    }
}
