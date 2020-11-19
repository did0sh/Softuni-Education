package p05_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1km;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostPer1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1km = fuelCostPer1km;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getFuelCostPer1km() {
        return this.fuelCostPer1km;
    }

    public void checkIfCarCanTravel(double fuelAmount, double fuelCostPer1km, int amountOfKm){
        double distance = this.fuelCostPer1km * amountOfKm;
        if (distance <= fuelAmount){
            this.fuelAmount -= distance;
            this.distanceTraveled += amountOfKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }
}
