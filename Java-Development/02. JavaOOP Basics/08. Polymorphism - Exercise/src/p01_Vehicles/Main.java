package p01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");

        double fuelQuantityCar = Double.parseDouble(carInfo[1]);
        double litersPerKmCar = Double.parseDouble(carInfo[2]);

        Car car = new Car(fuelQuantityCar,litersPerKmCar);

        double fuelQuantityTruck = Double.parseDouble(truckInfo[1]);
        double litersPerKmTruck = Double.parseDouble(truckInfo[2]);

        Car truck = new Truck(fuelQuantityTruck, litersPerKmTruck);

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String type = info[1];
            String command = info[0];
            double numberBasedOnCommand = Double.parseDouble(info[2]);

            switch (command){
                case "Drive":
                    if (type.equalsIgnoreCase("car")){
                        car.drive(numberBasedOnCommand);
                    } else if (type.equalsIgnoreCase("truck")) {
                        truck.drive(numberBasedOnCommand);
                    }
                    break;
                case "Refuel":
                    if (type.equalsIgnoreCase("car")){
                        car.refuel(numberBasedOnCommand);
                    } else if (type.equalsIgnoreCase("truck")) {
                        truck.refuel(numberBasedOnCommand);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
