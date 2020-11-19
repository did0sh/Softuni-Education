package exam.benders;

import exam.Bender;

public class WaterBender extends Bender {
    private double waterClarity;
    private double totalPower;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
        calcTotalPower();
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    private void calcTotalPower() {
        this.totalPower = super.getPower() * this.getWaterClarity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Water Bender: %s, Power: %d, Water Clarity: %.2f%n",
                super.getName(), super.getPower(), this.getWaterClarity()));
        return sb.toString();
    }
}
