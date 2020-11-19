package exam;

public abstract class Bender {
    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    protected int getPower() {
        return this.power;
    }

    protected String getName() {
        return this.name;
    }
}
