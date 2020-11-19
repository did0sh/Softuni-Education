package p09_Animals.models;

import p09_Animals.abstractClasses.Animal;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
