package p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> allPeople = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[1];
            switch (command) {
                case "company":
                    addCompany(tokens, allPeople);
                    break;
                case "pokemon":
                    addPokemon(tokens, allPeople);
                    break;
                case "parents":
                    addParents(tokens, allPeople);
                    break;
                case "children":
                    addChildren(tokens, allPeople);
                    break;
                case "car":
                    addCar(tokens, allPeople);
                    break;
            }
            input = reader.readLine();
        }

        input = reader.readLine();
        printInfo(input, allPeople);
    }

    private static void printInfo(String input, Map<String, Person> allPeople) {
       List<Map.Entry<String, Person>> personInfo = allPeople.entrySet().stream()
                .filter(kv -> kv.getKey().equals(input))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Person> stringPersonEntry : personInfo) {
            sb.append(stringPersonEntry.getKey()).append(System.lineSeparator());

            sb.append("Company:").append(System.lineSeparator());

            if (stringPersonEntry.getValue().getCompany() != null){
                sb.append(String.format("%s %s %.2f%n", stringPersonEntry.getValue().getCompany().getName(),
                        stringPersonEntry.getValue().getCompany().getDepartment(),
                        stringPersonEntry.getValue().getCompany().getSalary()));
            }

            sb.append("Car:").append(System.lineSeparator());

            if (stringPersonEntry.getValue().getCar() != null){
                sb.append(String.format("%s %d%n", stringPersonEntry.getValue().getCar().getModel(),
                        stringPersonEntry.getValue().getCar().getSpeed()));
            }

            sb.append("Pokemon:").append(System.lineSeparator());

            if (stringPersonEntry.getValue().getPokemons().size() > 0){
                stringPersonEntry.getValue().getPokemons().forEach(pokemon -> sb.append(String.format("%s %s%n",
                        pokemon.getName(), pokemon.getType())));
            }

            sb.append("Parents:").append(System.lineSeparator());

            if (stringPersonEntry.getValue().getParents().size() > 0){
                stringPersonEntry.getValue().getParents().forEach(parent -> sb.append(String.format("%s %s%n",
                        parent.getName(), parent.getBirthday())));
            }

            sb.append("Children:").append(System.lineSeparator());

            if (stringPersonEntry.getValue().getChildren().size() > 0){
                stringPersonEntry.getValue().getChildren().forEach(child -> sb.append(String.format("%s %s%n",
                        child.getName(), child.getBirthday())));
            }
        }
        System.out.print(sb.toString());
    }

    private static void addCar(String[] tokens, Map<String, Person> allPeople) {
        String personName = tokens[0];
        String model = tokens[2];
        int speed = Integer.parseInt(tokens[3]);

        Car car = new Car(model, speed);

        if (!allPeople.containsKey(personName)) {
            allPeople.put(personName, new Person());
        }
        allPeople.get(personName).setCar(car);
    }

    private static void addChildren(String[] tokens, Map<String, Person> allPeople) {
        String personName = tokens[0];
        String childName = tokens[2];
        String childBirthday = tokens[3];

        Child child = new Child(childName, childBirthday);
        List<Child> children = new ArrayList<>();
        children.add(child);

        if (!allPeople.containsKey(personName)) {
            allPeople.put(personName, new Person());
        }
        allPeople.get(personName).setChildren(children);
    }

    private static void addParents(String[] tokens, Map<String, Person> allPeople) {
        String personName = tokens[0];
        String parentName = tokens[2];
        String parentBirthday = tokens[3];

        Parent parent = new Parent(parentName, parentBirthday);
        List<Parent> parents = new ArrayList<>();
        parents.add(parent);

        if (!allPeople.containsKey(personName)) {
            allPeople.put(personName, new Person());
        }
        allPeople.get(personName).setParents(parents);
    }

    private static void addPokemon(String[] tokens, Map<String, Person> allPeople) {
        String personName = tokens[0];
        String pokemonName = tokens[2];
        String pokemonType = tokens[3];

        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon);

        if (!allPeople.containsKey(personName)) {
            allPeople.put(personName, new Person());
        }
        allPeople.get(personName).setPokemons(pokemons);
    }

    private static void addCompany(String[] tokens, Map<String, Person> allPeople) {
        String personName = tokens[0];
        String companyName = tokens[2];
        String department = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        Company company = new Company(companyName, department, salary);

        if (!allPeople.containsKey(personName)) {
            allPeople.put(personName, new Person());
        }
        allPeople.get(personName).setCompany(company);
    }
}
