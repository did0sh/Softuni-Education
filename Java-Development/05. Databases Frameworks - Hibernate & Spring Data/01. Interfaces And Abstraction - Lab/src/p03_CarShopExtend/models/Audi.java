package p03_CarShopExtend.models;

import p03_CarShopExtend.contracts.Rentable;

public class Audi implements Rentable {
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private int minRentDays;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDays, double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires.%nMinRentDays: %d, Price per Day: %.2f",
                this.getModel(), this.getCountryProduced(), TIRES, this.getMinRentDay(), this.getPricePerDay());
    }
}
