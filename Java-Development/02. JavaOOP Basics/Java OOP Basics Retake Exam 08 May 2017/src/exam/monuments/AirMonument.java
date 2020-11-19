package exam.monuments;

import exam.Monument;

public class AirMonument extends Monument {
    private int airAffinity;
    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAirAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Air Monument: %s, Air Affinity: %d%n",
                super.getName(), this.getAirAffinity()));
        return sb.toString();
    }

    @Override
    protected int getProperty() {
        return this.airAffinity;
    }
}
