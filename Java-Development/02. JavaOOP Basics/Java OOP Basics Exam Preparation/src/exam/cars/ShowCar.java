package exam.cars;

import exam.Car;

public class ShowCar extends Car {
    private int stars;
    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);

    }

    @Override
    protected void tune(int tuneIndex, String addOn) {
        super.setHorsePower(super.getHorsePower() + tuneIndex);
        super.setSuspension(super.getSuspension() + tuneIndex/2);
        this.setStars(this.getStars() + tuneIndex);
        super.calcEnginePerf();
        super.calcSuspensionPerf();
        super.calcOverallPerf();
    }


    private int getStars() {
        return this.stars;
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("%d *", this.getStars())).append(System.lineSeparator());

        return sb.toString();
    }
}
