package exam.benders;

import exam.Bender;

public class AirBender extends Bender {
    private double aerialIntegrity;
    private double totalPower;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
        calcTotalPower();
    }

    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    private void calcTotalPower() {
        this.totalPower = super.getPower() * this.getAerialIntegrity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Air Bender: %s, Power: %d, Aerial Integrity: %.2f%n",
                super.getName(), super.getPower(), this.getAerialIntegrity()));
        return sb.toString();
    }
}
