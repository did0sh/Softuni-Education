package p01_Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    public abstract void drive(double kilometers);
    public abstract void refuel(double liters);
}
