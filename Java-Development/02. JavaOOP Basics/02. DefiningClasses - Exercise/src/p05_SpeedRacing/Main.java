package p05_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model,fuelAmount, fuelCost);
            cars.putIfAbsent(model, car);
        }

        String input = scan.nextLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String carModel = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            double fuelAmountCurrentCar = cars.get(carModel).getFuelAmount();
            double fuelCost = cars.get(carModel).getFuelCostPer1km();

            cars.get(carModel).checkIfCarCanTravel(fuelAmountCurrentCar, fuelCost,distance);
            input = scan.nextLine();
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.printf("%s %.2f %d%n", entry.getKey(), entry.getValue().getFuelAmount(), entry.getValue().getDistanceTraveled());
        }
    }
}
