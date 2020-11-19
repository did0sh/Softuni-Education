package app.models;

import app.abstractModels.AbstractLogger;
import app.interfaces.ObservableTarget;
import app.interfaces.Observer;
import app.interfaces.Target;
import app.enums.LogType;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements ObservableTarget {

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private AbstractLogger logger;
    private List<Observer> observers;

    public Dragon(String id, int hp, int reward, AbstractLogger logger) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.logger = logger;
        this.observers = new ArrayList<>();
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            logger.handle(LogType.ERROR, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this.reward));
    }
}
