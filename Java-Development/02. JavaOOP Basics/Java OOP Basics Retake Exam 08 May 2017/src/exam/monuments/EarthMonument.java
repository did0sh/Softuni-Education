package exam.monuments;

import exam.Monument;

public class EarthMonument extends Monument {
    private int earthAffinity;
    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    public int getEarthAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Earth Monument: %s, Earth Affinity: %d%n",
                super.getName(), this.getEarthAffinity()));
        return sb.toString();
    }

    @Override
    protected int getProperty() {
        return this.earthAffinity;
    }
}
