package p03_CarShopExtended;

public class Audi implements Rentable {
    private String model;
    private String color;
    private Integer horsePower;
    private Integer minRentDay;
    private Double pricePerDay;
    private String countryProduced;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    public String getCountryProduced() {
        return this.countryProduced;
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
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("This is %s produced in %s and have %d tires", this.getModel(),
                this.getCountryProduced(), TIRES));
        return sb.toString();
    }
}
