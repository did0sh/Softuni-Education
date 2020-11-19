package p06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> allBirthables = new ArrayList<>();

        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            switch (type){
                case "Citizen":
                    execCitizen(tokens, allBirthables);
                    break;
                case "Pet":
                    execPet(tokens, allBirthables);
                    break;
                case "Robot":
                    execRobot(tokens);
                    break;
            }
        }

        input = reader.readLine();
        printIdentifiable(allBirthables, input);
    }

    private static void execCitizen(String[] tokens, List<Birthable> birthables){
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String id = tokens[3];
        String birthday = tokens[4];

        Birthable citizen = new Citizen(name,age,id,birthday);
        birthables.add(citizen);
    }

    private static void execPet(String[] tokens, List<Birthable> birthables){
        String name = tokens[1];
        String birthday = tokens[2];

        Birthable pet = new Pet(name,birthday);
        birthables.add(pet);
    }

    private static void execRobot(String[] tokens){
        String model = tokens[1];
        String id = tokens[2];

        Identifiable robot = new Robot(model,id);
    }

    private static void printIdentifiable(List<Birthable> birthables, String input){
        StringBuilder sb = new StringBuilder();
        for (Birthable birthable : birthables) {
            String year = birthable.getBirthday().split("/")[2];
            if (year.equals(input)){
                sb.append(birthable.getBirthday()).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
