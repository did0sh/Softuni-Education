package p05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> allIdentifiables = new ArrayList<>();

        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Identifiable citizen = new Citizen(name, age, id);
                allIdentifiables.add(citizen);
            } else if (tokens.length == 2){
                String model = tokens[0];
                String id = tokens[1];

                Identifiable robot = new Robot(model, id);
                allIdentifiables.add(robot);
            }
        }

        input = reader.readLine();
        printIdentifiable(allIdentifiables, input);
    }

    private static void printIdentifiable(List<Identifiable> identifiables, String input){
        StringBuilder sb = new StringBuilder();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(input)){
                sb.append(identifiable.getId()).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
