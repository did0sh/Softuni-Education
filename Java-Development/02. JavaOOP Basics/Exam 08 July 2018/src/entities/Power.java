package entities;

import contracts.SuperPower;

import java.util.regex.Pattern;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        String regex = "^@[A-Za-z_]{5,}@$";
        if (Pattern.matches(regex, name)){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }

    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints >= 0){
            this.powerPoints = powerPoints;
        } else {

            throw new IllegalArgumentException("Power points should be a positive number!");
        }

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints + this.getName().length() / 2;
    }

    @Override
    public String toString() {
        return null; //TODO
    }
}
