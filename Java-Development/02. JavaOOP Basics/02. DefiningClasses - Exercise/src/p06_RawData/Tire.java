package p06_RawData;

public class Tire {
    private int age;
    private double pressure;

    public Tire(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return this.age;
    }

    public double getPressure() {
        return this.pressure;
    }
}
