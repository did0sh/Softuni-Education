package p03_AnimalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;
    private double productPerDay;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (this.getAge() >= 0 && this.getAge() <= 5){
            this.productPerDay = 2;
        } else if (this.getAge() >=6 && this.getAge() <= 11){
            this.productPerDay = 1;
        } else if (this.getAge() > 11){
            this.productPerDay = 0.75;
        }

        return this.productPerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Chicken %s (age %d) can produce %.0f eggs per day.",
                this.getName(), this.getAge(), this.calculateProductPerDay()));

        return sb.toString();
    }
}
