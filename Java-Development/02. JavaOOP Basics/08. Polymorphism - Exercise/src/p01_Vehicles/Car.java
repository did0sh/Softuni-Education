package p01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double INCREASED_FUEL_CONSUMPTION_CAR =  0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    public void drive(double kilometers){
        DecimalFormat df = new DecimalFormat("#.##");
        double litersConsumed = (super.getFuelConsumptionPerKm() + INCREASED_FUEL_CONSUMPTION_CAR) * kilometers;
        if (this.getFuelQuantity() >= litersConsumed){
            this.setFuelQuantity(this.getFuelQuantity() - litersConsumed);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(kilometers));
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters){
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Car: %.2f", this.getFuelQuantity()));

        return sb.toString();
    }
}
