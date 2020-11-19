package p09_Animals.models;

import p09_Animals.abstractClasses.Animal;

public class Kitten extends Animal {

    public Kitten(String name, int age, String gender) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
