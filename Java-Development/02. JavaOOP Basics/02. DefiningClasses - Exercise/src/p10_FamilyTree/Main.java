package p10_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String personToFind = reader.readLine();

        List<Person> allPersons = new ArrayList<>();
        List<String> familyData = new ArrayList<>();

        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)){
            if (input.contains(" - ")){
                familyData.add(input);
            } else {
                String[] info = input.split("\\s+");
                String name = info[0] + " " + info[1];
                String birthDate = info[2];
                Person person = new Person(name, birthDate);
                allPersons.add(person);
            }
            input = reader.readLine();
        }

        for (String data : familyData) {
            String[] info = data.split(" - ");
            String parentInfo = info[0];
            String childInfo = info[1];

            Person parent = allPersons.stream()
                    .filter(person -> parentInfo.equals(person.getName()) || parentInfo.equals(person.getBirthDate()))
                    .findFirst().get();

            Person child = allPersons.stream()
                    .filter(person -> childInfo.equals(person.getName()) || childInfo.equals(person.getBirthDate()))
                    .findFirst().get();

            parent.getChildren().add(child);
            child.getParents().add(parent);
        }

        Person personToPrint = allPersons.stream()
                .filter(person -> personToFind.equals(person.getName()) || personToFind.equals(person.getBirthDate()))
                .findFirst().get();

        System.out.println(personToPrint);

    }
}
