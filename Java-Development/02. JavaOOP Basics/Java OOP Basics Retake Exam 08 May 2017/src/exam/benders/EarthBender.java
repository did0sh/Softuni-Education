package exam.benders;

import exam.Bender;

public class EarthBender extends Bender {
    private double groundSaturation;
    private double totalPower;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
        calcTotalPower();
    }

    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    private void calcTotalPower() {
        this.totalPower = super.getPower() * this.getGroundSaturation();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Earth Bender: %s, Power: %d, Ground Saturation: %.2f%n",
                super.getName(), super.getPower(), this.getGroundSaturation()));
        return sb.toString();
    }

}
