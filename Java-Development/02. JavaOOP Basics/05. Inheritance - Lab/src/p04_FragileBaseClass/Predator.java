package p04_FragileBaseClass;

public class Predator extends Animal {
    private int health;

    public void feed(Food food){
        super.foodEaten.add(food);
        this.health++;
    }

    public int getHealth() {
        return this.health;
    }
}
