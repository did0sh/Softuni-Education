package p03_WildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal {
    private final StringBuilder sb = new StringBuilder();
    public Zebra(String name, String type, Double weight,String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        } else {
           throw new IllegalArgumentException(String.format("%ss are not eating that type of food!%n",
                    this.getClass().getSimpleName()));
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
       sb.append(String.format("%s[%s, %s, %s, %d]", super.getType(),
                super.getName(), df.format(super.getWeight()), super.getLivingRegion(), super.getFoodEaten()));

       return sb.toString();
    }
}
