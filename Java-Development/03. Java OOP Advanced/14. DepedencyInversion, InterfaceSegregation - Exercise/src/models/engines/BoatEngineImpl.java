package models.engines;

import contracts.BoatEngine;
import Utility.Constants;
import Utility.Validator;

public abstract class BoatEngineImpl implements BoatEngine {

    private String model;
    private int horsepower;
    private int displacement;

    protected BoatEngineImpl(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    final int getHorsepower() {
        return this.horsepower;
    }

    final int getDisplacement() {
        return this.displacement;
    }

    @Override
    public String getModelName() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}