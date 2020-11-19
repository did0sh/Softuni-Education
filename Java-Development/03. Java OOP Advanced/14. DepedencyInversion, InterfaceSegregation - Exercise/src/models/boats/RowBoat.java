package models.boats;

import contracts.Race;
import Utility.Validator;

public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, boolean isMotorBoat, int oars) {
        super(model, weight, isMotorBoat);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double result = (this.oars * 100D) - super.getWeight() + race.getOceanCurrentSpeed();

        return result;
    }
}
