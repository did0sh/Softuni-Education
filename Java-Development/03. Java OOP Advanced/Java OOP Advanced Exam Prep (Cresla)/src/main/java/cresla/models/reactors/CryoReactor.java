package cresla.models.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends BaseReactor {
    private int cryoProductionIndex;

    public CryoReactor(Container container, int id, int cryoProductionIndex) {
        super(container, id);
        this.cryoProductionIndex = cryoProductionIndex;
    }


    @Override
    public long getTotalEnergyOutput() {
        long energy = super.getContainer().getTotalEnergyOutput() * cryoProductionIndex;
        if (energy > this.getTotalHeatAbsorbing()){
            energy = 0;
        }
        return energy;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d%n", this.getClass().getSimpleName(), super.getId()))
                .append(String.format("Energy Output: %d%n", this.getTotalEnergyOutput()))
                .append(String.format("Heat Absorbing: %d%n", this.getTotalHeatAbsorbing()))
                .append(String.format("Modules: %d", super.getModuleCount()));

        return sb.toString();
    }
}
