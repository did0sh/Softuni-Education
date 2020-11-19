package p09_Animals.models;

import p09_Animals.abstractClasses.Animal;

public class Tomcat extends Animal {

    public Tomcat(String name, int age, String gender) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
