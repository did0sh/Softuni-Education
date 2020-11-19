package p03_CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
