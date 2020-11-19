package p09_Animals.models;

import p09_Animals.abstractClasses.Animal;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}
