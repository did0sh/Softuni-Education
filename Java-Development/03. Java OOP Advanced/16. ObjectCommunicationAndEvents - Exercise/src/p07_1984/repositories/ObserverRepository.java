package p07_1984.repositories;

import p07_1984.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverRepository {
    private List<Observer> observers;

    public ObserverRepository() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public Iterable<Observer> getAllObservers() {
        return this.observers;
    }
}