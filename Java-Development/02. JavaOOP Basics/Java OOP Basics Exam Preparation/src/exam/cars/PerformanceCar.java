package exam.cars;

import exam.Car;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends Car {
    private Collection<String> addOns;
    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void tune(int tuneIndex, String addOn) {
        super.setHorsePower(super.getHorsePower() + tuneIndex);
        super.setSuspension(super.getSuspension() + tuneIndex/2);
        this.addOns.add(addOn);
        super.calcEnginePerf();
        super.calcSuspensionPerf();
        super.calcOverallPerf();
    }

    @Override
    public void setHorsePower(int horsePower) {
        int power = horsePower + (50*horsePower)/100;
        super.setHorsePower(power);
    }

    @Override
    public void setSuspension(int suspension) {
        int susp = suspension - (25*suspension)/100;
        super.setSuspension(susp);
    }

    private Collection<String> getAddOns() {
        return this.addOns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (this.getAddOns().size() == 0){
            sb.append(String.format("Add-ons: None")).append(System.lineSeparator());
        } else {
            sb.append(String.format("Add-ons: %s%n", String.join(", ", this.getAddOns())));
        }

        return sb.toString();
    }
}
