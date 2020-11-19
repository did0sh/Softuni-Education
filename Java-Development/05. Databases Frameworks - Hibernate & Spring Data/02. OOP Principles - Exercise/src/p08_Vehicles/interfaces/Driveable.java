package p08_Vehicles.interfaces;

public interface Driveable {
    double getFuelQuantity();

    double getFuelConsumptionPerKm();

    void refuel(double fuel);

    String drive(double kilometers);
}
