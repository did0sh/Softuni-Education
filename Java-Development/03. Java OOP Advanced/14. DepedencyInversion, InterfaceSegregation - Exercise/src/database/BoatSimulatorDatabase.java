package database;

import contracts.BoatEngine;
import models.boats.Boat;

public class BoatSimulatorDatabase {
    private static final BoatSimulatorDatabase INSTANCE = new BoatSimulatorDatabase();

    private RepositoryImpl<Boat> boats;
    private RepositoryImpl<BoatEngine> engines;

    private BoatSimulatorDatabase() {
        this.boats = new RepositoryImpl<>();
        this.engines = new RepositoryImpl<>();
    }

    public static BoatSimulatorDatabase getInstance() {
        return INSTANCE;
    }

    public RepositoryImpl<Boat> getBoats() {
        return this.boats;
    }

    public RepositoryImpl<BoatEngine> getEngines() {
        return this.engines;
    }
}
