package p03_WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    private final StringBuilder sb = new StringBuilder();
    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
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
