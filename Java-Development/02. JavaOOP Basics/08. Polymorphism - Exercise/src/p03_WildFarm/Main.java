package p03_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        while (true){
            String[] info = reader.readLine().split("\\s+");
            if (info[0].equalsIgnoreCase("end")){
                break;
            }
            String[] foodInfo = reader.readLine().split("\\s+");

            String name = info[1];
            double weight = Double.parseDouble(info[2]);
            String livingRegion = info[3];
            String animalType = info[0];

            Animal animal = null;
            switch (animalType){
                case "Cat":
                    String breed = info[4];
                    animal = new Cat(name, animalType, weight, livingRegion, breed);
                    break;
                case "Mouse":
                    animal = new Mouse(name, animalType, weight, livingRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(name, animalType, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name, animalType, weight, livingRegion);
                    break;
                    default:
                        throw new IllegalArgumentException("Invalid animal type!");
            }

            animals.add(animal);
            animal.makeSound();

            String typeOfFood = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            Food food;
            switch (typeOfFood){
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid food type!");
            }

            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae){
                System.out.print(iae.getMessage());
            }

        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
