package p03_WildFarm;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    public Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.setFoodEaten(0);
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    protected String getName() {
        return this.name;
    }

    protected String getType() {
        return this.type;
    }

    protected double getWeight() {
        return this.weight;
    }

    abstract void makeSound();
    abstract void eat(Food food);
}
