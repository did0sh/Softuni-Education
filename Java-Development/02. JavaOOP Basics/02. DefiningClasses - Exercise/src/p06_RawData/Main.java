package p06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        Map<String, Car> cars = new LinkedHashMap<>();


        for (int i = 0; i < lines; i++) {
            Car car = null;
            String[] tokens = reader.readLine().split("\\s+");
            String carModel = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Set<Tire> tires = new HashSet<>();

            for (int j = 5; j < tokens.length ; j+=2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j+1]);
                Tire tire = new Tire(tireAge, tirePressure);
                tires.add(tire);
            }

            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engineSpeed, enginePower);

            car = new Car(carModel, engine, cargo, tires);

            cars.putIfAbsent(carModel, car);
        }

        String input = reader.readLine();
        switch (input){
            case "fragile":
               cars.entrySet().stream()
                        .filter(kv1 -> kv1.getValue().getCargo().getType().equals("fragile"))
                        .filter(kv -> kv.getValue().getTires().stream()
                                .filter(tire -> {
                                    return tire.getPressure() < 1;
                                })
                                .collect(Collectors.toList())
                                .size() > 0)
                       .forEach(car -> System.out.println(car.getKey()));
               break;

            case "flamable":
                cars.entrySet().stream()
                        .filter(kv -> kv.getValue().getCargo().getType().equals("flamable"))
                        .filter(kv -> kv.getValue().getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getKey()));
                break;
        }
    }
}
