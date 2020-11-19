package p08_Vehicles.models;

import p08_Vehicles.interfaces.Driveable;

public abstract class BaseVehicle implements Driveable {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    protected BaseVehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }
}
