package p07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> people = new TreeSet<>();
        Set<Person> personSet = new HashSet<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] personInfo = reader.readLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            Person person = new Person(name,age);
            people.add(person);
            personSet.add(person);
        }

        System.out.println(people.size());
        System.out.println(personSet.size());
    }
}
