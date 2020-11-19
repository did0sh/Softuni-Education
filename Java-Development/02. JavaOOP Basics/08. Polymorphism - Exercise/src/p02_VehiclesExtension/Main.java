package p02_VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");
        String[] busInfo = reader.readLine().split("\\s+");

        Vehicle car = null;
        try {
            double fuelQuantityCar = Double.parseDouble(carInfo[1]);
            double litersPerKmCar = Double.parseDouble(carInfo[2]);
            double tankCapacityCar = Double.parseDouble(carInfo[3]);

            car = new Car(fuelQuantityCar, litersPerKmCar, tankCapacityCar);
        } catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }


        Vehicle truck = null;
        try {
            double fuelQuantityTruck = Double.parseDouble(truckInfo[1]);
            double litersPerKmTruck = Double.parseDouble(truckInfo[2]);
            double tankCapacityTruck = Double.parseDouble(truckInfo[3]);

           truck = new Truck(fuelQuantityTruck, litersPerKmTruck, tankCapacityTruck);
        } catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }

        Vehicle bus = null;
        try {
            double fuelQuantityBus = Double.parseDouble(busInfo[1]);
            double litersPerKmBus = Double.parseDouble(busInfo[2]);
            double tankCapacityBus = Double.parseDouble(busInfo[3]);

            bus = new Bus(fuelQuantityBus, litersPerKmBus, tankCapacityBus);
        }catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }

        boolean carNotNull = false;
        boolean busNotNull = false;
        boolean truckNotNull = false;

        if (car != null){
            carNotNull = true;
        }

        if (bus != null){
            busNotNull = true;
        }

        if (truck != null){
            truckNotNull = true;
        }

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String type = info[1];
            String command = info[0];
            double numberBasedOnCommand = Double.parseDouble(info[2]);

            switch (command) {
                case "Drive":
                    if (type.equalsIgnoreCase("car")) {
                        if (carNotNull){
                            car.drive(numberBasedOnCommand);
                        }
                    } else if (type.equalsIgnoreCase("truck")) {
                        if (truckNotNull){
                            truck.drive(numberBasedOnCommand);
                        }
                    } else if (type.equalsIgnoreCase("bus")) {
                        if (busNotNull){
                            bus.drive(numberBasedOnCommand);
                        }
                    }
                    break;
                case "DriveEmpty":
                    if (busNotNull){
                        bus.setFuelConsumptionPerKm(bus.getFuelConsumptionPerKm() - 1.4);
                        bus.drive(numberBasedOnCommand);
                    }
                        break;
                case "Refuel":
                    if (type.equalsIgnoreCase("car")) {
                        if (carNotNull){
                            try{
                                car.refuel(numberBasedOnCommand);
                            }catch (IllegalStateException ise){
                                System.out.println(ise.getMessage());
                            }
                        }
                    } else if (type.equalsIgnoreCase("truck")) {
                        if (truckNotNull){
                            try{
                                truck.refuel(numberBasedOnCommand);
                            }catch (IllegalStateException ise){
                                System.out.println(ise.getMessage());
                            }
                        }
                    } else if (type.equalsIgnoreCase("bus")) {
                        if (busNotNull){
                            try{
                                bus.refuel(numberBasedOnCommand);
                            }catch (IllegalStateException ise){
                                System.out.println(ise.getMessage());
                            }
                        }
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
