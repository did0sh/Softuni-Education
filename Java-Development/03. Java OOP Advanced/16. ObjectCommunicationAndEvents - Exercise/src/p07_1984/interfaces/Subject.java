package p07_1984.interfaces;

import p07_1984.models.Change;

public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyAllObservers(Change change);
}
