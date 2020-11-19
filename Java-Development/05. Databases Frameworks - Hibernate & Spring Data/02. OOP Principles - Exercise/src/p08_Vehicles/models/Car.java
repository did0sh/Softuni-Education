package p08_Vehicles.models;

import java.text.DecimalFormat;

public class Car extends BaseVehicle {
    private static final double SUMMERCONSUMPTION = 0.9;
    private static final DecimalFormat df = new DecimalFormat("#.################");

    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + SUMMERCONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }

    @Override
    public String drive(double kilometers) {
        double fuelNeeded = kilometers * super.getFuelConsumptionPerKm();
        if (super.getFuelQuantity() - fuelNeeded < 0){
            throw new IllegalArgumentException("Car needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
        return String.format("Car travelled %s km", df.format(kilometers));
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
