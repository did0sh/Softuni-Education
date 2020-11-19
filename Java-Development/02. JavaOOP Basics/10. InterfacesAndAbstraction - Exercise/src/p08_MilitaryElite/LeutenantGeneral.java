package p08_MilitaryElite;

import java.util.*;

public class LeutenantGeneral extends Private {
    private Set<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    public void addPrivate(Private privateSoldier){
        this.privates.add(privateSoldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f", super.getFirstName(),
                super.getLastName(), super.getId(), this.getSalary())).append(System.lineSeparator());

        sb.append("Privates:").append(System.lineSeparator());

        this.privates.stream().sorted((pr1, pr2) -> pr2.getId().compareTo(pr1.getId()))
                .forEach(sb::append);
        return sb.toString();
    }
}
