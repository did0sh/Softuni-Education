package exam;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    private int overallPerformance;
    private int enginePerformance;
    private int suspensionPerformance;

    public Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsePower(horsePower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;

        this.calcEnginePerf();
        this.calcSuspensionPerf();
        this.calcOverallPerf();

    }

    protected void calcOverallPerf(){
        this.overallPerformance = this.horsePower / this.acceleration +  this.suspension + this.durability;
    }

    protected void calcEnginePerf(){
        this.enginePerformance = this.horsePower / this.acceleration;
    }

    protected void calcSuspensionPerf(){
        this.suspensionPerformance = this.suspension + this.durability;
    }

    public int getOverallPerformance() {
        return this.overallPerformance;
    }

    public int getEnginePerformance() {
        return this.enginePerformance;
    }

    public int getSuspensionPerformance() {
        return this.suspensionPerformance;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    protected int getYearOfProduction() {
        return this.yearOfProduction;
    }

    protected int getHorsePower() {
        return this.horsePower;
    }

    protected int getAcceleration() {
        return this.acceleration;
    }

    protected int getSuspension() {
        return this.suspension;
    }

    protected int getDurability() {
        return this.durability;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    protected abstract void tune(int tuneIndex, String addOn);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s", this.getHorsePower(), this.getAcceleration()))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
