package cresla.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Reactor extends Identifiable {

    long getTotalEnergyOutput() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;

    long getTotalHeatAbsorbing() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    int getModuleCount() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException;

    void addEnergyModule(EnergyModule energyModule) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    void addAbsorbingModule(AbsorbingModule absorbingModule) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
