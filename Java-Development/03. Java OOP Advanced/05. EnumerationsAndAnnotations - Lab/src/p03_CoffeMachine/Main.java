package p03_CoffeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        CoffeeMachine machine = new CoffeeMachine();

        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] info = input.split("\\s+");
            switch (info[0]) {
                case "Small":
                        machine.buyCoffee(info[0], info[1]);
                        break;
                case "Normal":
                    machine.buyCoffee(info[0], info[1]);
                    break;
                case "Double":
                    machine.buyCoffee(info[0], info[1]);
                    break;
                default:
                    machine.insertCoin(info[0]);
                    break;
            }
        }

        for (Coffee coffee : machine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
