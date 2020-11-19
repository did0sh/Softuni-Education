package p04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();


        String input = reader.readLine();
        String[] tokens = input.split(";");

        for (int j = 0; j < tokens.length; j++) {

            String[] items = tokens[j].split("=");
            String name = items[0];
            int money = Integer.parseInt(items[1]);

            Person person = null;
            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            people.put(name, person);
        }

        input = reader.readLine();
        tokens = input.split(";");
        for (int i = 0; i < tokens.length; i++) {
            String[] items = tokens[i].split("=");
            String productName = items[0];
            int productCost = Integer.parseInt(items[1]);
            Product product = null;

            try {
                product = new Product(productName, productCost);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            products.put(productName, product);
        }

        input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)) {
            String[] commandArgs = input.split("\\s+");
            String personName = commandArgs[0];
            String productName = commandArgs[1];

            if (people.containsKey(personName) && products.containsKey(productName)) {
                Person currentPerson = people.get(personName);
                Product currentProduct = products.get(productName);

                try {
                    currentPerson.tryPurchase(currentProduct);
                } catch (IllegalStateException ex){
                    System.out.print(ex.getMessage());
                }

            }
            input = reader.readLine();
        }

        for (Map.Entry<String, Person> stringPersonEntry : people.entrySet()) {
            System.out.println(stringPersonEntry.getValue());
        }
    }
}
