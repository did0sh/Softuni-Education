package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {

    private VehicleAssembler vehicleAssembler;

    private AttackModifyingPart attackModifyingPart;

    private DefenseModifyingPart defenseModifyingPart;

    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);

    }

    @Test
    public void getTotalWeight() throws Exception {
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(30.0);

        double actualWeight = this.vehicleAssembler.getTotalWeight();
        double expectedWeight = 60.0;

        Assert.assertEquals(expectedWeight, actualWeight, 0.1);
    }

    @Test
    public void getTotalPrice() throws Exception {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);

        BigDecimal actualResult = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedResult = BigDecimal.valueOf(12);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTotalAttackModification() throws Exception {
        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(10);

        long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expected = 30;

        Assert.assertEquals(expected,actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() throws Exception {
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(10);

        long actualTotalDefenceModification = this.vehicleAssembler.getTotalDefenseModification();
        long expected = 30;

        Assert.assertEquals(expected,actualTotalDefenceModification);
    }

    @Test
    public void getTotalHitPointModification() throws Exception {
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(10);

        long actualTotalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
        long expected = 30;

        Assert.assertEquals(expected,actualTotalHitPointsModification);
    }

    @Test
    public void addArsenalPart() throws Exception {

        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);

        Mockito.when(part.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        this.vehicleAssembler.addArsenalPart(part);
        this.vehicleAssembler.addArsenalPart(part1);

        long totalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, totalAttackModification);
    }

    @Test
    public void addShellPart() throws Exception {
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);


        Mockito.when(part.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        this.vehicleAssembler.addShellPart(part);
        this.vehicleAssembler.addShellPart(part1);

        long totalDefenceModification = this.vehicleAssembler.getTotalDefenseModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, totalDefenceModification);
    }

    @Test
    public void addEndurancePart() throws Exception {
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);


        Mockito.when(part.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        this.vehicleAssembler.addEndurancePart(part);
        this.vehicleAssembler.addEndurancePart(part1);

        long totalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, totalHitPointsModification);
    }

}