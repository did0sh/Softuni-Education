package p06_RawData;

import java.util.Set;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Set<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, Set<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Set<Tire> getTires() {
        return this.tires;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
