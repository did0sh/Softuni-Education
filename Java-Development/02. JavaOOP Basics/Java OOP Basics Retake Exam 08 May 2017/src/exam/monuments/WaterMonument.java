package exam.monuments;

import exam.Monument;

public class WaterMonument extends Monument {
    private int waterAffinity;
    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    public int getWaterAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Water Monument: %s, Water Affinity: %d%n",
                super.getName(), this.getWaterAffinity()));
        return sb.toString();
    }

    @Override
    protected int getProperty() {
        return this.waterAffinity;
    }
}
