package exam.monuments;

import exam.Monument;

public class FireMonument extends Monument {
    private int fireAffinity;
    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    public int getFireAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fire Monument: %s, Fire Affinity: %d%n",
                super.getName(), this.getFireAffinity()));
        return sb.toString();
    }

    @Override
    protected int getProperty() {
        return this.fireAffinity;
    }
}
