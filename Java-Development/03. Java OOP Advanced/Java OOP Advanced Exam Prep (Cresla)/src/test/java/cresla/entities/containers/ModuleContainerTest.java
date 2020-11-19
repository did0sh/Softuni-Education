package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

public class ModuleContainerTest {

    private AbsorbingModule module1;
    private AbsorbingModule module2;
    private EnergyModule module3;
    private EnergyModule module4;
    private Container container;

    @Before
    public void init(){
        this.container = new ModuleContainer(3);
        this.module1 = Mockito.mock(AbsorbingModule.class);
        this.module2 = Mockito.mock(AbsorbingModule.class);
        this.module3 = Mockito.mock(EnergyModule.class);
        this.module4 = Mockito.mock(EnergyModule.class);

        Mockito.when(module1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(module2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(module3.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(module4.getEnergyOutput()).thenReturn(2_000_000_000);

        Mockito.when(module1.getId()).thenReturn(1);
        Mockito.when(module2.getId()).thenReturn(2);
        Mockito.when(module3.getId()).thenReturn(3);
        Mockito.when(module4.getId()).thenReturn(4);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleWithNullShouldThrowException() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleWithNullShouldThrowException() {
        this.container.addAbsorbingModule(null);
    }

    @Test()
    public void expectToRemoveModule() {
        this.container.addAbsorbingModule(module1);
        this.container.addEnergyModule(module3);
        this.container.addEnergyModule(module4);
        this.container.addEnergyModule(module4);

        Assert.assertEquals(this.container.getTotalEnergyOutput(), 4_000_000_000L);
        Assert.assertEquals(this.container.getTotalHeatAbsorbing(), 0);
    }

    @Test()
    public void absorbingModelWorksWithLong() {
        this.container.addAbsorbingModule(module1);
        this.container.addAbsorbingModule(module2);

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(), 4_000_000_000L);
    }

    @Test()
    public void addEnergyModule() {
        this.container.addEnergyModule(module3);
        this.container.addEnergyModule(module4);

        Assert.assertEquals(this.container.getTotalEnergyOutput(), 4_000_000_000L);
    }

    @Test()
    public void emptyContainerReturnsZero() {

        Assert.assertEquals(this.container.getTotalHeatAbsorbing(), 0);
        Assert.assertEquals(this.container.getTotalEnergyOutput(), 0);
    }

    @Test
    public void addAbsorbingModule() {
        this.container.addAbsorbingModule(this.module1);
        Assert.assertEquals(this.container.getTotalHeatAbsorbing(), 2_000_000_000L);
    }

    @Test
    public void getTotalEnergyOutput() {
        this.container.addEnergyModule(this.module3);
        this.container.addEnergyModule(this.module4);

        Assert.assertEquals(this.container.getTotalEnergyOutput() , 4_000_000_000L);
    }

    @Test
    public void getTotalHeatAbsorbing() {
        this.container.addAbsorbingModule(this.module1);
        this.container.addAbsorbingModule(this.module2);

        Assert.assertEquals(this.container.getTotalHeatAbsorbing() , 4_000_000_000L);
    }

    @Test(expected = NoSuchElementException.class)
    public void ZeroSize() {
        this.container = new ModuleContainer(0);
        this.container.addAbsorbingModule(this.module1);
    }
}