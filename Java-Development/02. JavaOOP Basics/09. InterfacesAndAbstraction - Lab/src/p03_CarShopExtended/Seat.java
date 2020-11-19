package p03_CarShopExtended;

public class Seat implements Sellable {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
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
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }


    public String getCountryProduced() {
        return this.countryProduced;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("This is %s produced in %s and have %d tires", this.getModel(),
                this.getCountryProduced(), TIRES));
        return sb.toString();
    }
}
