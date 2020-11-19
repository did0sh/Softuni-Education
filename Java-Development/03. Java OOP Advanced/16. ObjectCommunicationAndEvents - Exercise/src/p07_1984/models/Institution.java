package p07_1984.models;

import p07_1984.interfaces.Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Institution implements Observer {

    private String id;
    private String name;
    private Set<String> subjects;
    private List<Change> changes;

    public Institution(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new HashSet<>();
        this.changes = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addSubject(String name) {
        this.subjects.add(name);
    }

    @Override
    public void logChange(Change change) {
        if (this.subjects.contains(change.getFieldName())) {
            this.changes.add(change);
        }
    }

    @Override
    public void printLogs() {
        for (Change change : this.changes) {
            System.out.println(change);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d changes registered", this.name, this.changes.size());
    }
}
