package p05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Dough {
    private static final double DEFAULT_CALORIES_PER_GRAM = 2;

    private List<String> types;
    private List<Double> modifier;
    private int weight;
    private double calories;

    public Dough(int weight, List<String> types) {
        this.types = new ArrayList<>();
        this.setType(types);
        this.setWeight(weight);
        this.modifier = new ArrayList<>();
    }

    public void setType(List<String> types) {
        for (String type : types) {
            if (type.equals("White") || type.equals("Wholegrain")
                    || type.equals("Crispy")
                    || type.equals("Chewy")
                    || type.equals("Homemade")) {
                this.types.add(type);
            } else {
                throw new IllegalStateException("Invalid type of dough.");
            }
        }
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public void addModifier(String type) {
        if (type.equals("White")) {
            this.modifier.add(1.5);
        } else if (type.equals("Wholegrain")) {
            this.modifier.add(1.0);
        } else if (type.equals("Crispy")) {
            this.modifier.add(0.9);
        } else if (type.equals("Chewy")) {
            this.modifier.add(1.1);
        } else if (type.equals("Homemade")) {
            this.modifier.add(1.0);
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
