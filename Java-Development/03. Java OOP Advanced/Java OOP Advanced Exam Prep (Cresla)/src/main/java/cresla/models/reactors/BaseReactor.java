package cresla.models.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.models.modules.BaseModule;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;

    BaseReactor(Container container, int id) {
        this.id = id;
        this.container = container;
    }

    Container getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        Class moduleContainer = ModuleContainer.class;
        Field field = moduleContainer.getDeclaredFields()[1];
        field.setAccessible(true);
        try {
            return ((LinkedList<BaseModule>)field.get(this.container)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }
}
