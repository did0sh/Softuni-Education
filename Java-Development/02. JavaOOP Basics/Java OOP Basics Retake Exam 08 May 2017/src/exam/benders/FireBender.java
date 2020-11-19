package exam.benders;

import exam.Bender;

public class FireBender extends Bender {
    private double heatAggression;
    private double totalPower;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
        calcTotalPower();
    }

    public double getHeatAggression() {
        return this.heatAggression;
    }

    private void calcTotalPower() {
        this.totalPower = super.getPower() * this.getHeatAggression();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f%n",
                super.getName(), super.getPower(), this.getHeatAggression()));
        return sb.toString();
    }
}
