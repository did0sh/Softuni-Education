package p05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        List<Person> people = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String town = info[2];
            Person person = new Person(name, age, town);

            people.add(person);
        }

        int index = Integer.parseInt(reader.readLine()) - 1;
        Person currentPerson = people.get(index);

        int countEqual = 0;
        for (Person person : people) {
            if (currentPerson.compareTo(person) == 0){
                countEqual++;
            }
        }

        if (countEqual == 1){
            System.out.println("No matches");
        } else {
            int notEqual = people.size() - countEqual;
            System.out.printf("%d %d %d%n", countEqual, notEqual, people.size());
        }
    }
}
