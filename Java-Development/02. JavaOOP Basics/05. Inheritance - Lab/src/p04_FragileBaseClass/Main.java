package p04_FragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();

        Food food = new Food();

        predator.feed(food);
        predator.feed(food);
        predator.feed(food);

        System.out.println(predator.getHealth());
    }
}
