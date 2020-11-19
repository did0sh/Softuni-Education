package p06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        Set<Person> peopleComparedByNames = new TreeSet<>(new PersonNameComparator());
        Set<Person> peopleComparedByAge = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < lines; i++) {
            String[] personInfo = reader.readLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            Person person = new Person(name, age);
            peopleComparedByNames.add(person);
            peopleComparedByAge.add(person);
        }

        peopleComparedByNames.forEach(System.out::println);
        peopleComparedByAge.forEach(System.out::println);
    }
}
