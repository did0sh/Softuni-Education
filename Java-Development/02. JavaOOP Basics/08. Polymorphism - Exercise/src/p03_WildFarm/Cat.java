package p03_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;
    private final StringBuilder sb = new StringBuilder();
    public Cat(String name, String type, Double weight, String livingRegion,String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    protected String getBreed() {
        return this.breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

        sb.append(String.format("%s[%s, %s, %s, %s, %d]", super.getType(),
                super.getName(), this.getBreed(), df.format(super.getWeight()), super.getLivingRegion(), super.getFoodEaten()));

        return sb.toString();
    }
}
