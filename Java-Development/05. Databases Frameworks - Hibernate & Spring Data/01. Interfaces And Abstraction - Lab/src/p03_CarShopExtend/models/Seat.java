package p03_CarShopExtend.models;

import p03_CarShopExtend.contracts.Sellable;

public class Seat implements Sellable {
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced, double price){
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
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
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryProduced(), TIRES);
    }
}
