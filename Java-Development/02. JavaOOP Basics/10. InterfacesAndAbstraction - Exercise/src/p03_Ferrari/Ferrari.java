package p03_Ferrari;

public class Ferrari implements Drivable {
    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.model = "488-Spider";
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s/%s/%s/%s", this.getModel(), this.pushBrakes(), this.pushGasPedal(),
                this.getDriverName()));
        return sb.toString();
    }
}
