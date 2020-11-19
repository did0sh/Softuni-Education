package cresla.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;
    AbstractAbsorbingModule(int id, int property) {
        super(id);
        this.heatAbsorbing = property;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Module - " +
                super.getId() + System.lineSeparator() +
                "Heat Absorbing: " + this.heatAbsorbing;
    }
}
