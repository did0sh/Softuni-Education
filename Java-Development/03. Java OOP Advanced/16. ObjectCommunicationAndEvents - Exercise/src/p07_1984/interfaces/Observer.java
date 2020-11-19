package p07_1984.interfaces;

import p07_1984.models.Change;

public interface Observer {
    void logChange(Change change);

    void printLogs();

    void addSubject(String name);
}
