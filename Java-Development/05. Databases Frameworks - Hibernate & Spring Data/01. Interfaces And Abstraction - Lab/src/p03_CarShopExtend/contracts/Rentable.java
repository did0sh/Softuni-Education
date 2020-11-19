package p03_CarShopExtend.contracts;

public interface Rentable extends Car {
    int getMinRentDay();

    double getPricePerDay();
}
