package cresla.models.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends BaseReactor {
    private int heatProductionIndex;

    public HeatReactor(Container container,int id, int heatProductionIndex) {
        super(container, id);
        this.heatProductionIndex = heatProductionIndex;
    }


    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput();

        if(result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return  result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + this.heatProductionIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d%n", this.getClass().getSimpleName(), super.getId()))
                .append(String.format("Energy Output: %d%n", this.getTotalEnergyOutput()))
                .append(String.format("Heat Absorbing: %d%n", this.getTotalHeatAbsorbing()))
                .append(String.format("Modules: %d", this.getModuleCount()));

        return sb.toString();
    }
}
