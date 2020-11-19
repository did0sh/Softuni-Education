package p03_Ferrari.entities;

import p03_Ferrari.interfaces.Moveable;

public class Ferrari implements Moveable {
    private static final String MODEL = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.useBrakes(), this.pushGasPedal(),this.driverName);
    }
}
