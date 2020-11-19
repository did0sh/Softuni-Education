package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends BaseModule implements EnergyModule {
    private int energyOutput;
    AbstractEnergyModule(int id, int property) {
        super(id);
        this.energyOutput = property;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Module - " +
                super.getId() + System.lineSeparator() +
                "Energy Output: " + this.energyOutput;
    }
}
