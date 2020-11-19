package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    @Test
    public void weaponAttacksLosesDurability(){
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

        axe.attack(dummy);
        Assert.assertEquals("Wrong durability points",EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeaponThrowsException(){
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

        axe.attack(dummy);
        axe.attack(dummy);
    }
}
