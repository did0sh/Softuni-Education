package p01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Car {
    private static final double INCREASED_FUEL_CONSUMPTION_TRUCK = 1.6;
    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    public void drive(double kilometers) {
        DecimalFormat df = new DecimalFormat("#.##");
        double litersConsumed = (super.getFuelConsumptionPerKm() + INCREASED_FUEL_CONSUMPTION_TRUCK) * kilometers;
        if (super.getFuelQuantity() >= litersConsumed){
            super.setFuelQuantity(super.getFuelQuantity() - litersConsumed);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(kilometers));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        super.refuel(0.95 * liters);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Truck: %.2f", super.getFuelQuantity()));

        return sb.toString();
    }
}
