package models.engines;

public class SternDriveEngine extends BoatEngineImpl
{
    private static final int MULTIPLIER = 7;

    public SternDriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
    }
}
