package p08_Vehicles.models;

import java.text.DecimalFormat;

public class Truck extends BaseVehicle {
    private static final double SUMMERCONSUMPTION = 1.6;
    private static final DecimalFormat df = new DecimalFormat("#.################");

    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + SUMMERCONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + (0.95 * fuel));
    }

    @Override
    public String drive(double kilometers) {
        double fuelNeeded = kilometers * super.getFuelConsumptionPerKm();
        if (super.getFuelQuantity() - fuelNeeded < 0){
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
        return String.format("Truck travelled %s km", df.format(kilometers));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}