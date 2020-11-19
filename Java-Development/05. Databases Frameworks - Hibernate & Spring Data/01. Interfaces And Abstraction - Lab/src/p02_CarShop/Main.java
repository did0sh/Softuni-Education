package p02_CarShop;

import p02_CarShop.contracts.Car;
import p02_CarShop.models.Seat;

public class Main {
    public static void main(String[] args) {
        Car seat = new Seat("Leon", "gray", 110, "Spain");

                System.out.println(String.format(
                        "%s is %s color and have %s horse power",
                        seat.getModel(),
                        seat.getColor(),
                        seat.getHorsePower()));
        System.out.println(seat.toString());
    }

}
