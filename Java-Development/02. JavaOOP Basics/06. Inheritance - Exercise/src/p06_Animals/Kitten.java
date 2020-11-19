package p06_Animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound(){
        return "Miau";
    }

}
