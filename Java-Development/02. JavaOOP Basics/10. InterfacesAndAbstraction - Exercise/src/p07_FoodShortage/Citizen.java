package p07_FoodShortage;

public class Citizen implements Identifiable, Birthable, Buyer{
    private String name;
    private int age;
    private String id;
    private String birthDay;
    private int food;

    public Citizen(String name, int age, String id, String birthDay) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDay = birthDay;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthDay;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
