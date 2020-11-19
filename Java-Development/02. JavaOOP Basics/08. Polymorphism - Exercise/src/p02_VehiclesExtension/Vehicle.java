package p02_VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
        this.setTankCapacity(tankCapacity);
    }

    protected void refuel(double liters){
        if (liters <= 0){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    protected void drive(double kilometers){
        DecimalFormat df = new DecimalFormat("#.########");

        double litersConsumed = this.getFuelConsumptionPerKm() * kilometers;

        if (this.getFuelQuantity() >= litersConsumed){
            this.setFuelQuantity(this.getFuelQuantity() - litersConsumed);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(kilometers));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }
}
