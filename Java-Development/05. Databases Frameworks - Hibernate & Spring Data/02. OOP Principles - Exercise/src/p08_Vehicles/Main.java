package p08_Vehicles;

import p08_Vehicles.interfaces.Driveable;
import p08_Vehicles.models.Car;
import p08_Vehicles.models.Truck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");

        Driveable car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Driveable truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {
            String[] info = scan.nextLine().split("\\s+");
            switch (info[0]) {
                case "Drive":
                    if (info[1].equalsIgnoreCase("Car")) {
                        try {
                            System.out.println(car.drive(Double.parseDouble(info[2])));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }

                    } else if (info[1].equalsIgnoreCase("Truck")){
                        try {
                            System.out.println(truck.drive(Double.parseDouble(info[2])));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    }
                    break;

                case "Refuel":
                    if (info[1].equalsIgnoreCase("Car")) {
                        car.refuel(Double.parseDouble(info[2]));
                    } else if (info[1].equalsIgnoreCase("Truck")){
                       truck.refuel(Double.parseDouble(info[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
