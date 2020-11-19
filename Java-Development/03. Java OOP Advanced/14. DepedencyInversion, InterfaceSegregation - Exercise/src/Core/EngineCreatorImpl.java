package Core;

import contracts.BoatEngine;
import contracts.EngineCreator;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.DuplicateModelException;
import models.engines.JetEngine;
import models.engines.SternDriveEngine;

public class EngineCreatorImpl implements EngineCreator {
    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();

    public EngineCreatorImpl() {
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SternDriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new DuplicateModelException("Duplicated model");
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }
}
