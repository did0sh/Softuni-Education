package p05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private int numberOftoppings;
    private List<Toppings> toppings;
    private List<Dough> doughs;

    public Pizza(String name, int numberOftoppings) {
        this.setName(name);
        this.setNumberOftoppings(numberOftoppings);
        this.toppings = new ArrayList<>();
        this.doughs = new ArrayList<>();
    }

    public void addTopping(Toppings toppings) {
        this.toppings.add(toppings);
    }

    public void addDoughs(Dough doughs) {
        this.doughs.add(doughs);
    }

    public void setName(String name) {
        if (name.trim().length() == 0 || name.length() < 1 || name.length() > 15){
            throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setNumberOftoppings(int numberOftoppings) {
        if (numberOftoppings < 0 || numberOftoppings > 10){
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
        this.numberOftoppings = numberOftoppings;
    }

    private String getName() {
        return this.name;
    }

    private double calcTotalPizzaCalories(){
        double total = 0;
        for (Toppings topping : toppings) {
            total += topping.calcCalories();
        }
        for (Dough dough : doughs) {
            total += dough.calcCalories();
        }

        return total;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.calcTotalPizzaCalories());
    }
}
