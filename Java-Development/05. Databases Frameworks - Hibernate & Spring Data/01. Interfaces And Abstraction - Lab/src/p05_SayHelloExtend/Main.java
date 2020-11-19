package p05_SayHelloExtend;

import p05_SayHelloExtend.contracts.Person;
import p05_SayHelloExtend.models.Bulgarian;
import p05_SayHelloExtend.models.Chinese;
import p05_SayHelloExtend.models.European;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}
