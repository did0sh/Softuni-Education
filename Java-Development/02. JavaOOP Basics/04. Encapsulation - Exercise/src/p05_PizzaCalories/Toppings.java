package p05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Toppings {
    private static final double DEFAULT_CALORIES_PER_GRAM = 2;

    private String type;
    private List<Double> modifier;
    private int weight;
    private double calories;

    public Toppings(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
        this.modifier = new ArrayList<>();
    }

    public void setType(String type) {
        if (type.equals("Meat") || type.equals("Cheese")
                || type.equals("Veggies")
                || type.equals("Sauce")) {
            this.type = type;
        } else {
            throw new IllegalStateException(String.format("Cannot place %s on top of your pizza.", type));
        }
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalStateException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }

    public void addModifier(String type) {
        switch (type) {
            case "Meat":
                this.modifier.add(1.2);
                break;
            case "Cheese":
                this.modifier.add(1.1);
                break;
            case "Veggies":
                this.modifier.add(0.8);
                break;
            case "Sauce":
                this.modifier.add(0.9);
                break;
        }
    }

    public double calcCalories() {
        this.calories = (DEFAULT_CALORIES_PER_GRAM * this.weight);
        for (Double aDouble : modifier) {
            this.calories *= aDouble;
        }
        return this.calories;
    }
}
