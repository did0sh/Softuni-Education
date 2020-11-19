package p02_VehiclesExtension;


public class Truck extends Vehicle {
    private static final double INCREASED_FUEL_CONSUMPTION_TRUCK = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + INCREASED_FUEL_CONSUMPTION_TRUCK);
    }

    @Override
    protected void refuel(double liters) {
        if (liters > this.getTankCapacity()){
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        super.refuel(liters * 0.95);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %.2f",this.getClass().getSimpleName(), super.getFuelQuantity()));

        return sb.toString();
    }
}
