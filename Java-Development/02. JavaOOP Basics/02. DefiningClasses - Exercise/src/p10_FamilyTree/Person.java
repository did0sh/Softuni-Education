package p10_FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s%n", this.name, this.birthDate));
        sb.append("Parents:").append(System.lineSeparator());

        if (!this.getParents().isEmpty()){
            this.getParents().forEach(parent -> sb.append(String.format("%s %s%n", parent.getName(), parent.getBirthDate())));
        }

        sb.append("Children:").append(System.lineSeparator());

        if (!this.getChildren().isEmpty()){
            this.getChildren().forEach(child -> sb.append(String.format("%s %s%n", child.getName(), child.getBirthDate())));
        }

        return sb.toString();
    }
}
