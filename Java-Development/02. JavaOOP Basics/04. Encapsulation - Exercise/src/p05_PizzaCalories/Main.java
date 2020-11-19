package p05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] info = input.split("\\s+");
        String pizzaName = info[1];
        int numberOfToppings = Integer.parseInt(info[2]);

        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
            return;
        }

        input = reader.readLine();
        List<String> doughs = new ArrayList<>();
        info = input.split("\\s+");
        int weight = 0;
        for (int i = 1; i < info.length; i++) {
            try {
                weight = Integer.parseInt(info[i]);
            } catch (Exception ex){
                doughs.add(info[i]);
            }
        }

        Dough dough = null;
        try {
            dough = new Dough(weight, doughs);
            for (String s : doughs) {
                dough.addModifier(s);
            }
            dough.calcCalories();
            pizza.addDoughs(dough);
        } catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
            return;
        }


        input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            info = input.split("\\s+");
            String toppingType = info[1];
            int toppingWeight = Integer.parseInt(info[2]);

            Toppings topping = null;
            try {
                topping = new Toppings(toppingType, toppingWeight);
                topping.addModifier(toppingType);
                topping.calcCalories();
                pizza.addTopping(topping);
            }catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
                return;
            }
            input = reader.readLine();
        }

        System.out.println(pizza);
    }
}
