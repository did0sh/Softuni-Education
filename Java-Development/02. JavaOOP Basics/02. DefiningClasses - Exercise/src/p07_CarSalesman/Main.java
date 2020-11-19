package p07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String,Engine> allEngines = new LinkedHashMap<>();
        LinkedHashSet<Car> allCars = new LinkedHashSet<>();


        for (int i = 0; i < n; i++) {
            String[] engineInfo = reader.readLine().split("\\s+");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);

            switch (engineInfo.length){
                case 2:
                    Engine engine = new Engine(model,power);
                    allEngines.putIfAbsent(model,engine);
                    break;
                case 3:
                    try {
                        int displacement = Integer.parseInt(engineInfo[2]);
                        Engine engine1 = new Engine(model, power);
                        engine1.setDisplacement(String.valueOf(displacement));
                        allEngines.putIfAbsent(model,engine1);
                    } catch (Exception ex){
                        String efficiency = engineInfo[2];
                        Engine engine1 = new Engine(model, power);
                        engine1.setEfficiency(efficiency);
                        allEngines.putIfAbsent(model,engine1);
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(engineInfo[2]);
                    String efficiency = engineInfo[3];
                    Engine engine1 = new Engine(model, power);
                    engine1.setDisplacement(String.valueOf(displacement));
                    engine1.setEfficiency(efficiency);
                    allEngines.putIfAbsent(model,engine1);
                    break;
            }
        }

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] carInfo = reader.readLine().split("\\s+");
            String model = carInfo[0];
            String engine = carInfo[1];
            switch (carInfo.length){
                case 2:
                    Car car = new Car(model, allEngines.get(engine));
                    allCars.add(car);
                    break;
                case 3:
                    try {
                        int weight = Integer.parseInt(carInfo[2]);
                        Car car1 = new Car(model, allEngines.get(engine));
                        car1.setWeight(String.valueOf(weight));
                        allCars.add(car1);
                    } catch (Exception ex){
                        String color = carInfo[2];
                        Car car1 = new Car(model, allEngines.get(engine));
                        car1.setColor(color);
                        allCars.add(car1);
                    }
                    break;
                case 4:
                    Car car1 = new Car(model, allEngines.get(engine));
                    car1.setWeight(carInfo[2]);
                    car1.setColor(carInfo[3]);
                    allCars.add(car1);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Car carEngineEntry : allCars) {
            sb.setLength(0);
            sb.append(String.format("%s:%n", carEngineEntry.getModel()))
                    .append(String.format("%s:%n", carEngineEntry.getEngine().getModel()))
                    .append(String.format("Power: %s%n", carEngineEntry.getEngine().getPower()))
                    .append(String.format("Displacement: %s%n", carEngineEntry.getEngine().getDisplacement()))
                    .append(String.format("Efficiency: %s%n", carEngineEntry.getEngine().getEfficiency()))
                    .append(String.format("Weight: %s%n", carEngineEntry.getWeight()))
                    .append(String.format("Color: %s%n", carEngineEntry.getColor()));

            System.out.print(sb.toString());
        }
    }
}
