package p03_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
           Person person = new Person(name, age);
           persons.add(person);
        }

       persons.stream()
               .filter(p1 -> p1.getAge() > 30)
               .sorted(Comparator.comparing(Person::getName))
               .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));

    }
}
