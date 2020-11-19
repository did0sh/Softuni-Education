package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import models.boats.Boat;

public interface BoatCreator {
    Boat createRowBoat(String model, int weight, boolean isMotorBoat, int oars) throws DuplicateModelException;

    Boat createSailBoat(String model, int weight, boolean isMotorBoat, int sailEfficiency) throws DuplicateModelException;

    Boat createPowerBoat(String model, int weight, boolean isMotorBoat, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    Boat createYacht(String model, int weight, boolean isMotorBoat, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;
}
