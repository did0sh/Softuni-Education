package p09_Google;

public class Car {
    private String model;
    private int speed;

    public Car(String carModel, int carSpeed) {
        this.model = carModel;
        this.speed = carSpeed;
    }

    public String getModel() {
        return this.model;
    }

    public int getSpeed() {
        return this.speed;
    }
}
